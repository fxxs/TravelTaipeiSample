package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 相關圖片
 */
data class ImageResponse(
    // 圖片位址
    @SerializedName("src") var src: String,
    // 主旨
    @SerializedName("subject") var subject: String,
    // 格式
    @SerializedName("ext") var ext: String,
)