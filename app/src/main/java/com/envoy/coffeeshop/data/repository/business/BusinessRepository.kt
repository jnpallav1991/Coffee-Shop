package com.envoy.coffeeshop.data.repository.business

import androidx.paging.PagingData
import com.envoy.coffeeshop.data.model.Businesse
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {
    suspend fun getBusiness(location: String, category: String): Flow<PagingData<Businesse>>
}