package com.example.repository

import android.content.SharedPreferences
import com.example.model.Language
import javax.inject.Inject

class ConfigRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    companion object {
        const val LANG = "lang"
    }

    var language: Language = Language.ZH_TW
        set(newLanguage) {
            field = newLanguage
            with(sharedPreferences.edit()) {
                putString(LANG, newLanguage.lang)
                apply()
            }
        }

    init {
        val lang = sharedPreferences.getString(LANG, Language.ZH_TW.lang) ?: Language.ZH_TW.lang
        val foundLanguage = Language.values().find { it.lang == lang }
        language = foundLanguage ?: Language.ZH_TW
    }
}