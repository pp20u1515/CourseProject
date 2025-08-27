package ru.bmstu.dc.architectureanddi.data.datasource.local.mapper

import ru.bmstu.dc.database.entity.CredentialEntity
import ru.bmstu.dc.database.entity.UserEntity
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.model.User

//region entity -> domain
fun CredentialEntity.toDomain(): Credential = Credential(
    username = username,
    password = password
)

fun UserEntity.toDomain(): User = User(
    id = id,
    username = username,
    surname = surname,
    name = name,
    age = age,
    phoneNumber = phoneNumber
)
//endregion

//region domain -> entity
fun Credential.toEntity(): CredentialEntity =
    CredentialEntity(
        username = username,
        password = password
    )

fun User.toEntity(): UserEntity =
    UserEntity(
        id = id,
        username = username,
        surname = surname,
        name = name,
        age = age,
        phoneNumber = phoneNumber
    )
//endregion