package ru.bmstu.dc.architectureanddi.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCredentialsViewData(
    val username: String,
    val password: String
) : Parcelable
