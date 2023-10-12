package com.example.traveltaipei.ui.tour

import com.example.model.BaseResponse
import com.example.model.TourResponse
import com.example.traveltaipei.BaseFeatureViewModel
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.usecase.ConvertTourThemeUseCase
import com.example.traveltaipei.usecase.GetTourThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(
    private val getTourThemeUseCase: GetTourThemeUseCase,
) : BaseFeatureViewModel<TourResponse>() {

    init {
        getData()
    }

    override suspend fun call(page: Int): Result<BaseResponse<TourResponse>> {
        return getTourThemeUseCase(page)
    }

    override fun convert(list: List<TourResponse>): List<BaseListItem> {
        return ConvertTourThemeUseCase().invoke(list)
    }
}