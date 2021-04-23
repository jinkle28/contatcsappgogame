package com.example.contatcsappgogame.di.contactsList


import androidx.lifecycle.ViewModel
import com.example.contatcsappgogame.di.ViewModelKey
import com.example.contatcsappgogame.ui.contactsList.ContactsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactsListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsListViewModel::class)
    abstract fun bindContactsListViewModel(contactsListViewModel: ContactsListViewModel): ViewModel

}