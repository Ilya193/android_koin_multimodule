package ru.ikom.messages

import androidx.lifecycle.ViewModel
import ru.ikom.domain.Repository

class MessagesDepsViewModel(
    val repository: Repository,
) : ViewModel()