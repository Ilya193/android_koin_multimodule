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

    private val _state = MutableStateFlow("")
    val state: StateFlow<String> get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchMessages().collect {
                _state.value = it.toString()
            }
        }
    }
}