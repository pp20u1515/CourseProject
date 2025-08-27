package ru.bmstu.dc.architectureanddi.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.bmstu.dc.architectureanddi.domain.model.User

interface IUserRepository {
    suspend fun update()

    fun getAll(): Flow<List<User>>
}