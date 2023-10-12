package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 熱門景點
 */
data class
AttractionsResponse(
    // 編號
    @SerializedName("id") val id: Int? = -1,

    // 標題
    @SerializedName("name") val name: String? = "",

    // 標題
    @SerializedName("name_zh") val nameZH: String? = "",

    // 標題
    @SerializedName("open_status") val openStatus: Int? = -1,

    // 介紹
    @SerializedName("introduction") val introduction: String? = "",

    // 開放時間
    @SerializedName("open_time") val openTime: String? = "",

    // 郵遞區號
    @SerializedName("zipcode") val zipcode: String? = "",

    // 行政區
    @SerializedName("distric") val district: String? = "",

    // 地址
    @SerializedName("address") val address: String? = "",

    // 電話
    @SerializedName("tel") val tel: String? = "",

    // 傳真
    @SerializedName("fax") val fax: String? = "",

    // 電子郵件
    @SerializedName("email") val email: String? = "",

    // 月份
    @SerializedName("months") val months: String? = "",

    // 北緯
    @SerializedName("nlat") val latitude: Double? = -1.0,

    // 東經
    @SerializedName("elong") val longitude: Double? = -1.0,

    // 官方網站網址
    @SerializedName("official_site") val officialSite: String? = "",

    // 臉書粉絲頁網址
    @SerializedName("facebook") val facebook: String? = "",

    // 門票/收費
    @SerializedName("ticket") val ticket: String? = "",

    // 旅遊叮嚀
    @SerializedName("remind") val remind: String? = "",

    // 停留時間
    @SerializedName("staytime") val stayTime: String? = "",

    // 最後修改時間
    @SerializedName("modified") val modified: String? = "",

    // 資料源網址
    @SerializedName("url") val url: String? = "",

    // 主題分類
    @SerializedName("category") val category: List<CategoryResponse>? = emptyList(),

    // 對象
    @SerializedName("target") val target: List<TargetResponse>? = emptyList(),

    // 服務設施
    @SerializedName("service") val service: List<ServiceResponse>? = emptyList(),

    // 友善服務
    @SerializedName("friendly") val friendly: List<FriendlyResponse>? = emptyList(),

    // 相關圖片
    @SerializedName("images") val images: List<ImageResponse>? = emptyList(),

    // 相關附件
    @SerializedName("files") val files: List<FileResponse>? = emptyList(),

    // 相關連結
    @SerializedName("links") val links: List<LinkResponse>? = emptyList(),
) {
}