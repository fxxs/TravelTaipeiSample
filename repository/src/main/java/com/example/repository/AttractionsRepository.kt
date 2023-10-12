package com.example.repository

import com.example.model.AttractionsResponse
import com.example.model.BaseResponse
import com.example.model.Language
import com.example.retrofit.api.AttractionsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AttractionsRepository @Inject constructor(
    private val attractionsApi: AttractionsApi
) {
    /**
     * 景點
     * @param lang 語系, see [Language]
     * @param categoryIds 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param nlat 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param elong 查詢附近景點，經緯度(東經) WGS84
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getAttractionsAll(
        lang: Language,
        categoryIds: String? = null,
        nlat: Double? = null,
        elong: Double? = null,
        page: Int = 1,
    ): Result<BaseResponse<AttractionsResponse>> {
        return withContext(Dispatchers.IO) {
            attractionsApi.getAttractionsAll(lang.lang, categoryIds, nlat, elong, page)
        }
    }
}