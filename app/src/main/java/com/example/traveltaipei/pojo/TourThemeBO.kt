package com.example.traveltaipei.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TourThemeBO(
    override val itemViewType: ItemViewType = ItemViewType.NORMAL,
    val id: Int? = -1,
    val title: String? = "",
    val seasons: String? = "",
    val months: String? = "",
    val days: Int? = -1,
    val author: String? = "",
    val description: String? = "",
    val consume: String? = "",
    val remark: String? = "",
    val note: String? = "",
    val url: String? = "",
    val category: String? = "",
    val transport: String? = "",
    val users: String? = "",
    val modified: String? = "",
    val files: List<FileBO>? = mutableListOf(),
) : BaseListItem, Parcelable