package ru.bmstu.dc.architectureanddi.datasource.remote.model

data class UserDto(
    val id: Int,
    val username: String,
    val surname: String,
    val name: String,
    val age: Int,
    val phoneNumber: String,
)
