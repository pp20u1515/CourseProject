package ru.bmstu.dc.architectureanddi.data.datasource.local.service

import ru.bmstu.dc.architectureanddi.data.datasource.local.mapper.toDomain
import ru.bmstu.dc.architectureanddi.data.datasource.local.mapper.toEntity
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.database.db.Database

class CredentialDaoService(database: Database) {
    private val credentialDao = database.getCredentialDao()

    suspend fun insert(credential: Credential) {
        credentialDao.insert(credential.toEntity())
    }

    suspend fun read(): Credential? {
        return credentialDao.read()?.toDomain()
    }
}