package ru.bmstu.dc.architectureanddi.presentation.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.bmstu.dc.architectureanddi.domain.model.Credential
import ru.bmstu.dc.architectureanddi.domain.model.User
import ru.bmstu.dc.architectureanddi.domain.usecase.AuthenticateUseCase
import ru.bmstu.dc.architectureanddi.domain.usecase.GetUsersUseCase
import ru.bmstu.dc.architectureanddi.domain.usecase.UpdateUsersUseCase
import java.security.MessageDigest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authenticate: AuthenticateUseCase,
    private val getUsers: GetUsersUseCase,
    private val updateUsers: UpdateUsersUseCase,
) : ViewModel() {

    val users: Flow<List<User>> = getUsers()


    suspend fun authenticate() {
        authenticate(
            credential = Credential(
                username = "batmen",
                password = encryptWithSha1("123"),
            )
        )
    }

    suspend fun update() {
        updateUsers()
    }

    private fun encryptWithSha1(text: String): String = MessageDigest.getInstance("SHA-1")
        .digest(text.toByteArray())
        .joinToString("") { byte ->
            "%02x".format(byte)
        }
}