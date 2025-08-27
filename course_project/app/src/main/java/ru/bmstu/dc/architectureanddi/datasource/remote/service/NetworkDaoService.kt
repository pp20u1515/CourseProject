package ru.bmstu.dc.architectureanddi.datasource.remote.service

import ru.bmstu.dc.architectureanddi.data.datasource.remote.service.INetworkDaoService
import ru.bmstu.dc.architectureanddi.datasource.remote.dao.NetworkDao
import ru.bmstu.dc.architectureanddi.datasource.remote.mapper.toDomain
import ru.bmstu.dc.architectureanddi.datasource.remote.mapper.toDto
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.model.User

class NetworkDaoService(private val networkDao: NetworkDao) : INetworkDaoService {
    override suspend fun authenticate(credential: Credential): User? {
        return networkDao.authenticate(credential.toDto())?.toDomain()
    }

    override suspend fun getUsers(): List<User>? {
        return networkDao.getUsers()?.map { it.toDomain() }
    }
}