package com.example.retrofit.api

import com.example.model.BaseResponse
import com.example.model.CategoryResponse
import com.example.model.Language
import com.example.model.MiscellaneousCategory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 其他
 */
interface MiscellaneousApi {

    /**
     * 分類查詢
     * @param lang 語系, see [Language]
     * @param type 單元類型 , see [MiscellaneousCategory]
     */
    @GET(Categories)
    suspend fun getMiscellaneousCategories(
        @Path("lang") lang: String,
        @Query("type") type: MiscellaneousCategory,
    ): Result<BaseResponse<CategoryResponse>>

    companion object {
        const val Categories = "/open-api/{lang}/Miscellaneous/Categories"
    }
}