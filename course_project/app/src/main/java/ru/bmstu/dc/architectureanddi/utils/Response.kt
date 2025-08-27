package ru.bmstu.dc.architectureanddi.utils

data class Response<T>(
    val body: T,
    val isSuccessful: Boolean,
)
