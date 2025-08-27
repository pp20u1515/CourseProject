package ru.bmstu.dc.architectureanddi.data.repository

import ru.bmstu.dc.architectureanddi.data.datasource.local.service.CredentialDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.UserDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.remote.service.INetworkDaoService
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.repository.ICredentialRepository

class CredentialRepository(
    private val credentialDaoService: CredentialDaoService,
    private val userDaoService: UserDaoService,
    private val networkDaoService: INetworkDaoService,
) : ICredentialRepository {
    override suspend fun authenticate(credential: Credential) {
        val owner = networkDaoService.authenticate(credential)
        if (owner == null) {
            error("Ошибка авторизации")
        } else {
            userDaoService.insert(owner)
            credentialDaoService.insert(credential)
        }
    }
}