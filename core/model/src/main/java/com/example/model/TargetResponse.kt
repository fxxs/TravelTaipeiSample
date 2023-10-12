package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 對象
 */
data class TargetResponse(
    // 編號
    @SerializedName("id") var id: Long,
    // 名稱
    @SerializedName("name") var name: String,
)