package com.envoy.coffeeshop.ui.business

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.envoy.coffeeshop.base.BaseViewModel
import com.envoy.coffeeshop.data.model.Businesse
import com.envoy.coffeeshop.data.repository.business.BusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private val businessRepository: BusinessRepository) :
    BaseViewModel() {

    private lateinit var _searchResult: Flow<PagingData<Businesse>>

    val searchResult: Flow<PagingData<Businesse>>
        get() = _searchResult

    private val location = "410 Townsend Street, San Francisco, CA"

    private val category = "coffee"

    init {
        getBusinessResult()
    }

    private fun getBusinessResult() = launchPagingAsync(
        {
            businessRepository.getBusiness(location, category).cachedIn(viewModelScope)
        },
        {
            _searchResult = it
        })
}