package ru.ikom.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import ru.ikom.domain.Repository

class RepositoryImpl : Repository {

    override fun fetchMessages(): Flow<String> = callbackFlow {
        while (true) {
            delay(700)
            send("Message")
        }
    }
}