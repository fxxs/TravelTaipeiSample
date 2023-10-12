package com.example.traveltaipei.usecase

import com.example.model.BaseResponse
import com.example.model.TourResponse
import com.example.repository.ConfigRepository
import com.example.repository.TourRepository
import javax.inject.Inject

class GetTourThemeUseCase @Inject constructor(
    private val repository: TourRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(page: Int): Result<BaseResponse<TourResponse>> {
        return repository.getTourTheme(
            lang = configRepository.language,
            page = page
        )
    }
}