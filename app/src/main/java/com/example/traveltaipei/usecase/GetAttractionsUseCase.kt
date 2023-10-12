package com.example.traveltaipei.usecase

import com.example.model.AttractionsResponse
import com.example.model.BaseResponse
import com.example.repository.AttractionsRepository
import com.example.repository.ConfigRepository
import javax.inject.Inject

class GetAttractionsUseCase @Inject constructor(
    private val repository: AttractionsRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(page: Int): Result<BaseResponse<AttractionsResponse>> {
        return repository.getAttractionsAll(
            lang = configRepository.language,
            page = page
        )
    }
}