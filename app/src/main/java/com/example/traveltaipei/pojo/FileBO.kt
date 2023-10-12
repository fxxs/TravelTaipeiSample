package com.example.traveltaipei.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FileBO(
    val src: String? = "",
    val subject: String? = "",
    val ext: String? = "",
) : Parcelable
