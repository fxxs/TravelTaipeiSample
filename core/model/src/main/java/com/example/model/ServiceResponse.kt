package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 服務設施
 */
data class ServiceResponse(
    // 編號
    @SerializedName("id") var id: Long,
    // 名稱
    @SerializedName("name") var name: String,
)