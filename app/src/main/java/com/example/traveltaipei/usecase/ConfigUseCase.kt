package com.example.traveltaipei.usecase

import com.example.model.Language
import com.example.repository.ConfigRepository
import javax.inject.Inject

class ConfigUseCase @Inject constructor(
    private val configRepository: ConfigRepository,
) {
    operator fun invoke(language: Language): Boolean {
        if (configRepository.language != language) {
            configRepository.language = language
            return true
        }

        return false
    }
}