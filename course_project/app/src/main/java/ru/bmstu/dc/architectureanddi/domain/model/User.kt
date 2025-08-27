package ru.bmstu.dc.architectureanddi.domain.model

data class User(
    val id: Int,
    val username: String,
    val surname: String,
    val name: String,
    val age: Int,
    val phoneNumber: String,
)
