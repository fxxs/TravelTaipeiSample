package com.example.traveltaipei.usecase

import com.example.model.ActivityResponse
import com.example.model.BaseResponse
import com.example.repository.ConfigRepository
import com.example.repository.EventsRepository
import javax.inject.Inject

class GetEventActivityUseCase @Inject constructor(
    private val repository: EventsRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(page: Int): Result<BaseResponse<ActivityResponse>> {
        return repository.getEventsActivity(
            lang = configRepository.language,
            page = page
        )
    }
}