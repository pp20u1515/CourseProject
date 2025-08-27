package ru.bmstu.dc.architectureanddi.datasource.remote.api

import ru.bmstu.dc.architectureanddi.datasource.remote.model.CredentialDto
import ru.bmstu.dc.architectureanddi.utils.Response
import ru.bmstu.dc.architectureanddi.datasource.remote.model.UserDto
import ru.bmstu.dc.architectureanddi.utils.GET

interface NetworkApi {
    @GET("api/v2/authenticate")
    suspend fun authenticate(credential: CredentialDto): Response<UserDto>

    @GET("api/v2/users")
    suspend fun getUsers(): Response<List<UserDto>>
}