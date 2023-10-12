package com.example.traveltaipei.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventActivityBO(
    override val itemViewType: ItemViewType = ItemViewType.NORMAL,
    val id: Int? = -1,
    val title: String? = "",
    val description: String? = "",
    val begin: String? = "",
    val end: String? = "",
    val posted: String? = "",
    val modified: String? = "",
    val url: String? = "",
    val district: String? = "",
    val address: String? = "",
    val latitude: String? = "",
    val longitude: String? = "",
    val organizer: String? = "",
    val coOrganizer: String? = "",
    val contact: String? = "",
    val tel: String? = "",
    val fax: String? = "",
    val ticket: String? = "",
    val traffic: String? = "",
    val parking: String? = "",
    val files: List<FileBO>? = mutableListOf(),
    val links: List<LinkBO>? = mutableListOf(),
) : BaseListItem, Parcelable