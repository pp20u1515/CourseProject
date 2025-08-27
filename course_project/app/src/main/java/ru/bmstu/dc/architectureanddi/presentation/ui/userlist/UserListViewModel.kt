package ru.bmstu.dc.architectureanddi.presentation.ui.userlist

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.bmstu.dc.architectureanddi.R
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor() : ViewModel() {
    fun logout(view: View) {
        val direction = UserListFragmentDirections.actionUserListFragmentToAuthFragment()
        view.findNavController().navigate(direction)
    }

    fun getDetails(view: View) {
        val direction = UserListFragmentDirections.actionUserListFragmentToDetailsFragment()
        view.findNavController().navigate(direction)
    }
}