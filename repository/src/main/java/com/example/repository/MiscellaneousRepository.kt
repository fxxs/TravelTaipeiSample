package com.example.repository

import com.example.model.BaseResponse
import com.example.model.CategoryResponse
import com.example.model.Language
import com.example.model.MiscellaneousCategory
import com.example.retrofit.api.MiscellaneousApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MiscellaneousRepository @Inject constructor(
    private val miscellaneousApi: MiscellaneousApi
) {
    /**
     * 分類查詢
     * @param lang 語系, see [Language]
     * @param type 單元類型 , see [MiscellaneousCategory]
     */
    suspend fun getAttractionsAll(
        lang: Language,
        type: MiscellaneousCategory = MiscellaneousCategory.ACTIVITY,
    ): Result<BaseResponse<CategoryResponse>> {
        return withContext(Dispatchers.IO) {
            miscellaneousApi.getMiscellaneousCategories(lang.lang, type)
        }
    }
}