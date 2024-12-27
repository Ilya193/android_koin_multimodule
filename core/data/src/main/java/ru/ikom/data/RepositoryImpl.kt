package ru.ikom.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import ru.ikom.domain.Repository

class RepositoryImpl : Repository {

    private val messages = mutableListOf<String>()

    override fun fetchMessages(): Flow<List<String>> = callbackFlow {
        while (true) {
            delay(1000)
            messages.add("Message ${messages.size}")
            send(messages)
        }
    }
}