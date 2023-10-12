package com.example.traveltaipei.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LinkBO(
    val src: String? = "",
    val subject: String? = "",
) : Parcelable