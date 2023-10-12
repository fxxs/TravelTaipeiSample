package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 友善服務
 */
data class FriendlyResponse(
    // 編號
    @SerializedName("id") var id: Long,
    // 名稱
    @SerializedName("name") var name: String,
)