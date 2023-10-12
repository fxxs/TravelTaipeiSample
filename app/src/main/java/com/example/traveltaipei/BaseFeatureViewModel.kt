package com.example.traveltaipei

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.BaseResponse
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.pojo.ShimmerBO
import kotlinx.coroutines.launch

abstract class BaseFeatureViewModel<Response> : ViewModel() {
    private var page: Int = -1
    private var total: Int = 0
    private var totalPage: Int = 0
    private var loading = false
    var lastReceivedContentSize: Int = 0

    private val dataList: MutableList<BaseListItem> = initList()

    private val mutableListLiveData = MutableLiveData<List<BaseListItem>?>().apply {
        dataList
    }
    val immutableListLiveData: LiveData<List<BaseListItem>?> = mutableListLiveData

    private fun isAbleToCallApi(): Boolean {
        return page == -1 || (page in 1 until totalPage) && !loading
    }

    private fun initList(): MutableList<BaseListItem> {
        return mutableListOf(
            ShimmerBO(),
            ShimmerBO(),
            ShimmerBO(),
            ShimmerBO(),
            ShimmerBO(),
        )
    }

    protected fun getData() {
        if (isAbleToCallApi()) {
            viewModelScope.launch {
                if (page < 0) {
                    page = 1
                } else {
                    page += 1
                }
                lastReceivedContentSize = 0
                loading = true

                call(page).onSuccess {
                    total = it.total
                    totalPage = it.totalPage
                    if (page == 1) {
                        dataList.clear()
                    }

                    lastReceivedContentSize = it.data.size
                    dataList.addAll(convert(it.data))
                    mutableListLiveData.postValue(dataList.toList())
                    loading = false
                }.onFailure {
                    loading = false
                }
            }
        }
    }

    fun refresh() {
        page = -1
        total = 0
        totalPage = 0
        lastReceivedContentSize = 0
        dataList.clear()
        dataList.addAll(initList())
        mutableListLiveData.postValue(
            dataList.toList()
        )
        getData()
    }

    fun loadMore() {
        getData()
    }

    abstract suspend fun call(page: Int): Result<BaseResponse<Response>>

    abstract fun convert(list: List<Response>): List<BaseListItem>
}