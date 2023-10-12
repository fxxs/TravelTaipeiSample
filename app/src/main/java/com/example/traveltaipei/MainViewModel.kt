package com.example.traveltaipei

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.Language
import com.example.traveltaipei.usecase.ConfigUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val configUseCase: ConfigUseCase,
) : ViewModel() {

    private val _languageUpdated = MutableLiveData<Boolean>()
    val languageUpdated: LiveData<Boolean> = _languageUpdated

    fun setLanguage(language: Language) {
        if (configUseCase(language)) {
            _languageUpdated.postValue(true)
        }
    }
}