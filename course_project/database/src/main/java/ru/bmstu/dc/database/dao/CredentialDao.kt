package ru.bmstu.dc.database.dao

import ru.bmstu.dc.database.entity.CredentialEntity

interface CredentialDao {
    suspend fun insert(credential: CredentialEntity)

    suspend fun read(): CredentialEntity?
}