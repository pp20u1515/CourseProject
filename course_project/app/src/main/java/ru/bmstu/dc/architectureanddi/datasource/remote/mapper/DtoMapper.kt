package ru.bmstu.dc.architectureanddi.datasource.remote.mapper

import ru.bmstu.dc.architectureanddi.datasource.remote.model.CredentialDto
import ru.bmstu.dc.architectureanddi.datasource.remote.model.UserDto
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.model.User

//region dto -> domain
fun CredentialDto.toDomain(): Credential = Credential(
    username = username,
    password = password
)

fun UserDto.toDomain(): User = User(
    id = id,
    username = username,
    surname = surname,
    name = name,
    age = age,
    phoneNumber = phoneNumber
)
//endregion

//region domain -> dto
fun Credential.toDto(): CredentialDto = CredentialDto(
    username = username,
    password = password
)

fun User.toDto(): UserDto = UserDto(
    id = id,
    username = username,
    surname = surname,
    name = name,
    age = age,
    phoneNumber = phoneNumber
)
//endregion