package ru.ikom.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ikom.domain.Repository

class MessagesViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<List<Message>>(emptyList())
    val state: StateFlow<List<Message>> get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchMessages().collect {
                val newMessages = _state.value.toMutableList()
                newMessages.add(Message(_state.value.size, it + "${newMessages.size}"))
                _state.value = newMessages
            }
        }
    }
}