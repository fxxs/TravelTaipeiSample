package com.example.repository

import com.example.model.BaseResponse
import com.example.model.Language
import com.example.model.TourResponse
import com.example.retrofit.api.TourApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TourRepository @Inject constructor(
    private val tourApi: TourApi,
) {
    /**
     * 主題遊程
     * @param lang 語系, see [Language]
     * @param categoryIds 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getTourTheme(
        lang: Language,
        categoryIds: String? = null,
        page: Int = 1,
    ): Result<BaseResponse<TourResponse>> {
        return withContext(Dispatchers.IO) {
            tourApi.getTourTheme(lang.lang, categoryIds, page)
        }
    }
}