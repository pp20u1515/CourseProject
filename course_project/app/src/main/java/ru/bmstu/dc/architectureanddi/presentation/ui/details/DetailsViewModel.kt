package ru.bmstu.dc.architectureanddi.presentation.ui.details

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(): ViewModel() {
    fun navigateUp(view: View) {
        view.findNavController().navigateUp()
    }
}