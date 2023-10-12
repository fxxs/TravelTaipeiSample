package com.example.repository

import com.example.model.AudioResponse
import com.example.model.BaseResponse
import com.example.model.Language
import com.example.model.PanoResponse
import com.example.retrofit.api.MediaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MediaRepository @Inject constructor(
    private val mediaApi: MediaApi,
) {
    /**
     * 720°環景
     * @param lang 語系, see [Language]
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getMediaPanos(
        lang: Language,
        page: Int = 1,
    ): Result<BaseResponse<PanoResponse>> {
        return withContext(Dispatchers.IO) {
            mediaApi.getMediaPanos(lang.lang, page)
        }
    }

    /**
     * 語音導覽
     * @param lang 語系, see [Language]
     * @param page 頁碼。(每次回應30筆資料)
     */
    suspend fun getMediaAudio(
        lang: Language,
        page: Int = 1,
    ): Result<BaseResponse<AudioResponse>> {
        return withContext(Dispatchers.IO) {
            mediaApi.getMediaAudio(lang.lang, page)
        }
    }
}