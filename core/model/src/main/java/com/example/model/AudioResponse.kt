package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 環景
 */
data class
AudioResponse(
    // 編號
    @SerializedName("id") val id: Long,

    // 標題
    @SerializedName("title") val title: String,

    // 描述
    @SerializedName("summary") val summary: String,

    // 最後修改時間
    @SerializedName("modified") val modified: String,

    // 網址
    @SerializedName("url") val url: String,

    // 網址
    @SerializedName("file_ext") val file_ext: String,
)