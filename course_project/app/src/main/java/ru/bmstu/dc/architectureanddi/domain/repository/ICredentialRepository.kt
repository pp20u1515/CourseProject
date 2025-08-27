package ru.bmstu.dc.architectureanddi.domain.repository

import ru.bmstu.dc.architectureanddi.domain.model.Credential

interface ICredentialRepository {
    suspend fun authenticate(credential: Credential)
}