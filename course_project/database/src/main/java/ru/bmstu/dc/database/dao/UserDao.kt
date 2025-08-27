package ru.bmstu.dc.database.dao

import kotlinx.coroutines.flow.Flow
import ru.bmstu.dc.database.entity.UserEntity

interface UserDao {
    suspend fun insert(user: UserEntity)
    suspend fun insertAll(users: List<UserEntity>)
    fun readAll(): Flow<List<UserEntity>>
}