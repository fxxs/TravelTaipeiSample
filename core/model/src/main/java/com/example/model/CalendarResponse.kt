package com.example.model

import com.google.gson.annotations.SerializedName

/**
 *
 * 觀光行事曆
 */
data class
CalendarResponse(
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

    // 活動地點行政區
    @SerializedName("distric") val distric: String,

    // 活動地址
    @SerializedName("address") val address: String,

    // 北緯
    @SerializedName("nlat") val nlat: String,

    // 東經
    @SerializedName("elong") val elong: String,

    // 連絡電話
    @SerializedName("tel") val tel: String,

    // 傳真電話
    @SerializedName("fax") val fax: String,

    // 門票/收費資訊
    @SerializedName("ticket") val ticket: String,

    // 交通資訊
    @SerializedName("traffic") val traffic: String,

    // 停車資訊
    @SerializedName("parking") val parking: String,

    // 是否為大型活動
    @SerializedName("is_major") val is_major: Boolean,

    // 相關附件
    @SerializedName("files") val files: List<FileResponse>,

    // 相關連結
    @SerializedName("links") val links: List<LinkResponse>,
)