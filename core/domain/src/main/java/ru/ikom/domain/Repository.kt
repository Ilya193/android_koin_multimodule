package ru.ikom.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchMessages(): Flow<List<String>>
}