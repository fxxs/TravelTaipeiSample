package com.example.repository

import com.example.model.ActivityResponse
import com.example.model.BaseResponse
import com.example.model.CalendarResponse
import com.example.model.Language
import com.example.model.NewsResponse
import com.example.retrofit.api.EventsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventsRepository @Inject constructor(
    private val eventsApi: EventsApi,
) {
    /**
     * 最新消息 文字
     * @param lang 語系, see [Language]
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getEventsNews(
        lang: Language,
        begin: String? = null,
        end: String? = null,
        page: Int = 1,
    ): Result<BaseResponse<NewsResponse>> {
        return withContext(Dispatchers.IO) {
            eventsApi.getEventsNews(lang.lang, begin, end, page)
        }
    }

    /**
     * 活動展演
     * @param lang 語系, see [Language]
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getEventsActivity(
        lang: Language,
        begin: String? = null,
        end: String? = null,
        page: Int = 1,
    ): Result<BaseResponse<ActivityResponse>> {
        return withContext(Dispatchers.IO) {
            eventsApi.getEventsActivity(lang.lang, begin, end, page)
        }
    }

    /**
     * 活動年曆
     * @param lang 語系, see [Language]
     * @param categoryId 分類編號
     * @param begin 開始時間，格式 yyyy-MM-dd
     * @param end 結束時間，格式 yyyy-MM-dd
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getEventsCalendar(
        lang: Language,
        categoryId: Long? = null,
        begin: String? = null,
        end: String? = null,
        page: Int = 1,
    ): Result<BaseResponse<CalendarResponse>> {
        return withContext(Dispatchers.IO) {
            eventsApi.getEventsCalendar(lang.lang, categoryId, begin, end, page)
        }
    }
}