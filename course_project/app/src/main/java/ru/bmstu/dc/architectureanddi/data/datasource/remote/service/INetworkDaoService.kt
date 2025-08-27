package ru.bmstu.dc.architectureanddi.data.datasource.remote.service

import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.model.User

interface INetworkDaoService {
    suspend fun authenticate(credential: Credential): User?
    suspend fun getUsers(): List<User>?
}