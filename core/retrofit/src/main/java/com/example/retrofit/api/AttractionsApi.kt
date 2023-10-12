package com.example.retrofit.api

import com.example.model.AttractionsResponse
import com.example.model.BaseResponse
import com.example.model.Language
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 遊憩景點
 */
interface AttractionsApi {

    /**
     * 景點
     * @param lang 語系, see [Language]
     * @param categoryIds 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param nlat 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param elong 查詢附近景點，經緯度(東經) WGS84
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(ALL)
    suspend fun getAttractionsAll(
        @Path("lang") lang: String,
        @Query("categoryIds") categoryIds: String? = null,
        @Query("nlat") nlat: Double? = null,
        @Query("elong") elong: Double? = null,
        @Query("page") page: Int,
    ): Result<BaseResponse<AttractionsResponse>>

    companion object {
        const val ALL = "/open-api/{lang}/Attractions/All"
    }
}