package com.example.traveltaipei.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AttractionBO(
    override val itemViewType: ItemViewType = ItemViewType.NORMAL,
    val id: Int? = -1,
    val name: String? = "",
    val nameZH: String? = "",
    val openStatus: Int? = -1,
    val introduction: String? = "",
    val openTime: String? = "",
    val zipcode: String? = "",
    val district: String? = "",
    val address: String? = "",
    val tel: String? = "",
    val fax: String? = "",
    val email: String? = "",
    val months: String? = "",
    val latitude: Double? = -1.0,
    val longitude: Double? = -1.0,
    val officialSite: String? = "",
    val facebook: String? = "",
    val ticket: String? = "",
    val remind: String? = "",
    val stayTime: String? = "",
    val modified: String? = "",
    val url: String? = "",
//    val category: List<CategoryResponse>,
//    val target: List<TargetResponse>,
//    val service: List<ServiceResponse>,
//    val friendly: List<FriendlyResponse>,
    val images: List<String>? = emptyList(),
    val files: List<FileBO>? = mutableListOf(),
    val links: List<LinkBO>? = mutableListOf(),
) : BaseListItem, Parcelable