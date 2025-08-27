package ru.bmstu.dc.database.entity

data class UserEntity(
    val id: Int,
    val username: String,
    val surname: String,
    val name: String,
    val age: Int,
    val phoneNumber: String,
)
