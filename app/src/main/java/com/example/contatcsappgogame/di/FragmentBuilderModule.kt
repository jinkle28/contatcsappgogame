package com.example.contatcsappgogame.di

import  com.example.contatcsappgogame.di.addContact.AddContactViewModelModule
import  com.example.contatcsappgogame.di.contactDetails.ContactDetailsViewModelModule
import  com.example.contatcsappgogame.di.contactsList.ContactsListViewModelModule
import  com.example.contatcsappgogame.ui.addContact.AddContactFragment
import  com.example.contatcsappgogame.ui.contactDetails.ContactDetailsFragment
import com.example.contatcsappgogame.ui.contactsList.ContactsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ContactsListViewModelModule::class])
    abstract fun contributeContactsFragment() : ContactsListFragment

    @ContributesAndroidInjector(modules = [AddContactViewModelModule::class])
    abstract fun contributeAddContactFragment() : AddContactFragment

    @ContributesAndroidInjector(modules = [ContactDetailsViewModelModule::class])
    abstract fun contributeContactDetailsFragment() : ContactDetailsFragment
}