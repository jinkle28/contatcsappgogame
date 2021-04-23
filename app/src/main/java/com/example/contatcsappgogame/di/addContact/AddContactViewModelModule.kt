package com.example.contatcsappgogame.di.addContact

import androidx.lifecycle.ViewModel
import com.example.contatcsappgogame.di.ViewModelKey
import com.example.contatcsappgogame.ui.addContact.AddContactViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddContactViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddContactViewModel::class)
    abstract fun bindAddContactViewModel(addContactViewModel: AddContactViewModel): ViewModel

}