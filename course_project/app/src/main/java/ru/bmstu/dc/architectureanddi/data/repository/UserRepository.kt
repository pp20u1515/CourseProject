package ru.bmstu.dc.architectureanddi.data.repository

import kotlinx.coroutines.flow.Flow
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.UserDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.remote.service.INetworkDaoService
import ru.bmstu.dc.architectureanddi.domain.model.User
import ru.bmstu.dc.architectureanddi.domain.repository.IUserRepository

class UserRepository(
    private val userDaoService: UserDaoService,
    private val networkDaoService: INetworkDaoService,
) : IUserRepository {
    override suspend fun update() {
        val users = networkDaoService.getUsers()
        if (users != null) {
            userDaoService.insertAll(users)
        } else {
            error("Ошибка обновления данных")
        }
    }

    override fun getAll(): Flow<List<User>> {
        return userDaoService.readAll()
    }
}