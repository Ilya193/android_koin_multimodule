package ru.ikom.messages

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureMessages = module {
    viewModel<MessagesDepsViewModel> { params ->
        MessagesDepsViewModel(
            repository = get(),
        )
    }

    viewModel<MessagesViewModel> { params ->
        MessagesViewModel(
            repository = params.get()
        )
    }
}