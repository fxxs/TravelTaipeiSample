package com.example.traveltaipei.ui.events

import com.example.model.ActivityResponse
import com.example.model.BaseResponse
import com.example.traveltaipei.BaseFeatureViewModel
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.usecase.ConvertEventActivityUseCase
import com.example.traveltaipei.usecase.GetEventActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventActivityUseCase: GetEventActivityUseCase,
) : BaseFeatureViewModel<ActivityResponse>() {

    init {
        getData()
    }

    override suspend fun call(page: Int): Result<BaseResponse<ActivityResponse>> {
        return getEventActivityUseCase(page)
    }

    override fun convert(list: List<ActivityResponse>): List<BaseListItem> {
        return ConvertEventActivityUseCase().invoke(list)
    }
}