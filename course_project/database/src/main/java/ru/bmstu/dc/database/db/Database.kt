package ru.bmstu.dc.database.db

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.bmstu.dc.database.dao.CredentialDao
import ru.bmstu.dc.database.dao.UserDao
import ru.bmstu.dc.database.entity.CredentialEntity
import ru.bmstu.dc.database.entity.UserEntity

class Database {
    private val userStorage = MutableStateFlow<List<UserEntity>>(
        value = mutableListOf()
    )
    private val credentialStorage = MutableStateFlow<List<CredentialEntity>>(
        value = mutableListOf()
    )

    fun getUserDao(): UserDao {
        return object : UserDao {
            override suspend fun insert(user: UserEntity) {
                val currentUsers = userStorage.value
                userStorage.emit(currentUsers + user)
            }

            override suspend fun insertAll(users: List<UserEntity>) {
                val currentUsers = userStorage.value
                userStorage.emit(currentUsers + users)
            }

            override fun readAll(): Flow<List<UserEntity>> {
                return userStorage
            }

        }
    }

    fun getCredentialDao(): CredentialDao {
        return object : CredentialDao {
            override suspend fun insert(credential: CredentialEntity) {
                val currentCredentials = credentialStorage.value
                credentialStorage.emit(currentCredentials + credential)
            }

            override suspend fun read(): CredentialEntity? {
                return credentialStorage.value.firstOrNull()
            }

        }
    }
}