package com.example.retrofit.api

import com.example.model.BaseResponse
import com.example.model.Language
import com.example.model.TourResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 玩樂台北
 */
interface TourApi {

    /**
     * 主題遊程
     * @param lang 語系, see [Language]
     * @param categoryIds 查詢的分類編號(可輸入多個請以逗號,分隔)。例如 12,34,124
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(THEME)
    suspend fun getTourTheme(
        @Path("lang") lang: String,
        @Query("categoryIds") categoryIds: String? = null,
        @Query("page") page: Int,
    ): Result<BaseResponse<TourResponse>>

    companion object {
        const val THEME = "/open-api/{lang}/Tours/Theme"
    }
}