package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 相關連結
 */
data class LinkResponse(
    // 連結位址
    @SerializedName("src") var src: String,

    // 主旨
    @SerializedName("subject") var subject: String,
)