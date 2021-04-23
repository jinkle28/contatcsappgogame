package com.example.contatcsappgogame.di.contactDetails

import androidx.lifecycle.ViewModel
import com.example.contatcsappgogame.di.ViewModelKey
import com.example.contatcsappgogame.ui.contactDetails.ContactDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactDetailsViewModel::class)
    abstract fun bindContactDetailsViewModel(contactDetailsViewModel: ContactDetailsViewModel): ViewModel
}