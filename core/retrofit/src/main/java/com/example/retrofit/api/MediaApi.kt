package com.example.retrofit.api

import com.example.model.AudioResponse
import com.example.model.BaseResponse
import com.example.model.Language
import com.example.model.PanoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 影音刊物
 */
interface MediaApi {

    /**
     * 720°環景
     * @param lang 語系, see [Language]
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(PANOS)
    suspend fun getMediaPanos(
        @Path("lang") lang: String,
        @Query("page") page: Int,
    ): Result<BaseResponse<PanoResponse>>

    /**
     * 語音導覽
     * @param lang 語系, see [Language]
     * @param page 頁碼。(每次回應30筆資料)
     */
    @GET(AUDIO)
    suspend fun getMediaAudio(
        @Path("lang") lang: String,
        @Query("page") page: Int,
    ): Result<BaseResponse<AudioResponse>>

    companion object {
        private const val MEDIA = "/open-api/{lang}/Media"
        const val PANOS = "${MEDIA}/Panos"
        const val AUDIO = "${MEDIA}/Audio"
    }
}