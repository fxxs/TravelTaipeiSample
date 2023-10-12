package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 環景
 */
data class
PanoResponse(
    // 編號
    @SerializedName("id") val id: Long,

    // 標題
    @SerializedName("title") val title: String,

    // 最後修改時間
    @SerializedName("modified") val modified: String,

    // 網址
    @SerializedName("url") val url: String,
)