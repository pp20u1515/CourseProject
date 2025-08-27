package ru.bmstu.dc.architectureanddi.datasource.remote.dao

import ru.bmstu.dc.architectureanddi.datasource.remote.api.NetworkApi
import ru.bmstu.dc.architectureanddi.datasource.remote.model.CredentialDto
import ru.bmstu.dc.architectureanddi.datasource.remote.model.UserDto
import java.io.IOException

class NetworkDao(private val api: NetworkApi) {
    suspend fun authenticate(credential: CredentialDto): UserDto? {
        return try {
            val request = api.authenticate(credential)
            if (request.isSuccessful) {
                request.body
            } else {
                null
            }
        } catch (e: IOException) {
            null
        }

    }

    suspend fun getUsers(): List<UserDto>? {
        return try {
            val request = api.getUsers()
            if (request.isSuccessful) {
                request.body
            } else {
                null
            }
        } catch (e: IOException) {
            null
        }
    }
}