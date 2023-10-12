package com.example.traveltaipei.ui.attractions

import com.example.model.AttractionsResponse
import com.example.model.BaseResponse
import com.example.traveltaipei.BaseFeatureViewModel
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.usecase.ConvertAttractionsUseCase
import com.example.traveltaipei.usecase.GetAttractionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AttractionsViewModel @Inject constructor(
    private val getAttractionsUseCase: GetAttractionsUseCase,
) : BaseFeatureViewModel<AttractionsResponse>() {

    init {
        getData()
    }

    override suspend fun call(page: Int): Result<BaseResponse<AttractionsResponse>> {
        return getAttractionsUseCase(page)
    }

    override fun convert(list: List<AttractionsResponse>): List<BaseListItem> {
        return ConvertAttractionsUseCase().invoke(list)
    }
}