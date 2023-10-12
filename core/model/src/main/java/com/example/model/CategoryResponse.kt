package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 分類
 */
data class CategoryResponse(
    // 分類編號
    @SerializedName("id") var id: Long,
    // 分類名稱
    @SerializedName("name") var name: String,
)
