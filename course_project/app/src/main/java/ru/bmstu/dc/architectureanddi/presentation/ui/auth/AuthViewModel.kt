package ru.bmstu.dc.architectureanddi.presentation.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.bmstu.dc.architectureanddi.presentation.model.UserCredentialsViewData
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    fun authenticate(view: View) {
        val direction = AuthFragmentDirections.actionAuthFragmentToUserListFragment(
            credentials = UserCredentialsViewData(
                username = "batmen",
                password = "password",
            )
        )
        view.findNavController().navigate(direction)
    }
}