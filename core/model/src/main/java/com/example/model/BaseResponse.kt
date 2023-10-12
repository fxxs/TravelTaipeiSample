package com.example.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("total") val total: Int,
    @SerializedName("data") val data: List<T>,
) {
    val totalPage: Int
        get() = if (total > 0) (total / 30) + 1 else 0
}