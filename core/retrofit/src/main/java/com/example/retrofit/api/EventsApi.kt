package com.example.retrofit.api

import com.example.model.ActivityResponse
import com.example.model.BaseResponse
import com.example.model.CalendarResponse
import com.example.model.Language
import com.example.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 活動資訊
 */
interface EventsApi {

    /**
     * 最新消息 文字
     * @param lang 語系, see [Language]
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(NEWS)
    suspend fun getEventsNews(
        @Path("lang") lang: String,
        @Query("begin") begin: String? = null,
        @Query("end") end: String? = null,
        @Query("page") page: Int,
    ): Result<BaseResponse<NewsResponse>>

    /**
     * 活動展演
     * @param lang 語系, see [Language]
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(ACTIVITY)
    suspend fun getEventsActivity(
        @Path("lang") lang: String,
        @Query("begin") begin: String? = null,
        @Query("end") end: String? = null,
        @Query("page") page: Int,
    ): Result<BaseResponse<ActivityResponse>>

    /**
     * 活動年曆
     * @param lang 語系, see [Language]
     * @param categoryId 分類編號
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(CALENDAR)
    suspend fun getEventsCalendar(
        @Path("lang") lang: String,
        @Query("categoryId") categoryId: Long? = null,
        @Query("begin") begin: String? = null,
        @Query("end") end: String? = null,
        @Query("page") page: Int,
    ): Result<BaseResponse<CalendarResponse>>

    companion object {
        private const val EVENTS = "/open-api/{lang}/Events"
        const val NEWS = "${EVENTS}/News"
        const val ACTIVITY = "${EVENTS}/Activity"
        const val CALENDAR = "${EVENTS}/Calendar"
    }
}