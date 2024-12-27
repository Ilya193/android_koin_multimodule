package ru.ikom.messages

import androidx.lifecycle.ViewModel
import ru.ikom.domain.Repository

class MessagesDepsViewModel(
    deps: MessagesDeps
) : ViewModel() {
    val repository = deps.repository()
}

interface MessagesDeps {
    fun repository(): Repository
}