package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 活動資訊
 */
data class
NewsResponse(
    // 編號
    @SerializedName("id") val id: Int,

    // 標題
    @SerializedName("title") val title: String,

    // 內容
    @SerializedName("description") val description: String,

    // 資訊有效開始時間
    @SerializedName("begin") val begin: String,

    // 資訊有效結束時間
    @SerializedName("end") val end: String,

    // 發佈時間
    @SerializedName("posted") val posted: String,

    // 最後修改時間
    @SerializedName("modified") val modified: String,

    // 資料源網址
    @SerializedName("url") val url: String,

    // 相關附件
    @SerializedName("files") val files: List<FileResponse>,

    // 相關連結
    @SerializedName("links") val links: List<LinkResponse>,
)