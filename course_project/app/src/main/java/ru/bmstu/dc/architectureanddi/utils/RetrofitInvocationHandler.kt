package ru.bmstu.dc.architectureanddi.utils

import android.os.Build
import androidx.annotation.RequiresApi
import ru.bmstu.dc.architectureanddi.datasource.remote.model.CredentialDto
import ru.bmstu.dc.architectureanddi.datasource.remote.model.UserDto
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.util.UUID

class RetrofitInvocationHandler : InvocationHandler {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
        return when (method.name) {
            "authenticate" -> {
                val credentials = (args[0] as? CredentialDto)
                    ?: throw IllegalArgumentException("В метод переданы не верные параметры")
                getAuthResponse(credentials)
            }
            "getUsers" -> getUsers()
            else -> error("Неизвестное имя метода")
        }
    }

    private fun getAuthResponse(credentialsDto: CredentialDto): Response<UserDto> {
        return Response(
            body = UserDto(
                id = 4,
                username = credentialsDto.username,
                surname = "Elliott",
                name = "Rice",
                age = 14,
                phoneNumber = "(846) 831-7640"
            ),
            isSuccessful = true
        )
    }

    private fun getUsers(): Response<List<UserDto>> {
        return Response(
            body = listOf(
                UserDto(
                    id = 1,
                    username = "homelander",
                    surname = "Savage",
                    name = "Maggie",
                    age = 71,
                    phoneNumber = "(609) 704-5787"
                ),
                UserDto(
                    id = 2,
                    username = "butcher",
                    surname = "Huber",
                    name = "Sharron",
                    age = 50,
                    phoneNumber = "(277) 476-0859"
                ),
                UserDto(
                    id = 3,
                    username = "starlight",
                    surname = "Castro",
                    name = "Mathew",
                    age = 34,
                    phoneNumber = "(224) 604-7670"
                )
            ),
            isSuccessful = true
        )
    }
}