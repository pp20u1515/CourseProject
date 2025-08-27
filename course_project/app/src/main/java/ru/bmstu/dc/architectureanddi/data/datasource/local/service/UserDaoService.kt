package ru.bmstu.dc.architectureanddi.data.datasource.local.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.bmstu.dc.database.db.Database
import ru.bmstu.dc.architectureanddi.data.datasource.local.mapper.toDomain
import ru.bmstu.dc.architectureanddi.data.datasource.local.mapper.toEntity
import ru.bmstu.dc.architectureanddi.domain.model.User

class UserDaoService(database: Database) {
    private val userDao = database.getUserDao()
    suspend fun insert(user: User) {
        userDao.insert(user.toEntity())
    }

    suspend fun insertAll(users: List<User>) {
        userDao.insertAll(users.map { it.toEntity() })
    }

    fun readAll(): Flow<List<User>> {
        return userDao.readAll().map { users ->
            users.map { it.toDomain() }
        }
    }
}