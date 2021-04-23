package com.example.contatcsappgogame.ui.contactDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.contatcsappgogame.MainActivity
import com.example.contatcsappgogame.R
import com.example.contatcsappgogame.databinding.FragmentContactDetailsBinding
import com.example.contatcsappgogame.di.ViewModelProviderFactory
import com.example.contatcsappgogame.ui.addContact.AddContactFragmentDirections
import com.example.contatcsappgogame.util.OPTIONS
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_contacts_list.view.*
import javax.inject.Inject

class ContactDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: ContactDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentContactDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_details, container, false)

        binding.setLifecycleOwner(this.viewLifecycleOwner)

        viewModel = ViewModelProviders.of(this, factory).get(ContactDetailsViewModel::class.java)

        val args = ContactDetailsFragmentArgs.fromBundle(requireArguments())
        val contact = viewModel.getContactByInt(args.id)

        contact.observe(viewLifecycleOwner, Observer {
            binding.data.contact = it
        })

        binding.editContactFab.setOnClickListener {
            it.findNavController().navigate(
                ContactDetailsFragmentDirections
                    .actionContactDetailsFragmentToAddContactFragment(args.id)
            )
        }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.data.contact)
            it.findNavController().navigate(
                ContactDetailsFragmentDirections
                    .actionContactDetailsFragmentToContactsListFragment()
            )
        }

        requireActivity().onBackPressedDispatcher.addCallback(this)
        {
            // handling back button
            findNavController().navigate(ContactDetailsFragmentDirections.actionContactDetailsFragmentToContactsListFragment(), OPTIONS)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.title = "Contact Details"
    }

}