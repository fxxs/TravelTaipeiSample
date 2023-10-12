package com.example.model

import com.google.gson.annotations.SerializedName

/**
 * 遊程
 */
data class TourResponse(
    // 編號
    @SerializedName("id") var id: Int? = -1,
    // 名稱
    @SerializedName("title") var title: String? = "",

    @SerializedName("seasons") var seasons: List<String>? = mutableListOf(),
    @SerializedName("months") var months: List<String>? = mutableListOf(),
    @SerializedName("days") var days: Int? = -1,
    @SerializedName("author") var author: String? = "",
    @SerializedName("description") var description: String? = "",
    @SerializedName("consume") var consume: String? = "",
    @SerializedName("remark") var remark: String? = "",
    @SerializedName("note") var note: String? = "",
    @SerializedName("url") var url: String? = "",
    @SerializedName("category") var category: String? = "",
    @SerializedName("transport") var transport: String? = "",
    @SerializedName("users") var users: String? = "",
    @SerializedName("modified") var modified: String? = "",
    // 相關附件
    @SerializedName("files") val files: List<FileResponse>? = mutableListOf(),
)