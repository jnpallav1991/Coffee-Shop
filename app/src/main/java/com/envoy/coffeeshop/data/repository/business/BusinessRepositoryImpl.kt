package com.envoy.coffeeshop.data.repository.business

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.envoy.coffeeshop.data.model.Businesse
import com.envoy.coffeeshop.data.paging.BusinessPagingSource
import com.envoy.coffeeshop.data.paging.NETWORK_PAGE_SIZE
import com.envoy.coffeeshop.data.service.BusinessApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessRepositoryImpl @Inject constructor(
    private val service: BusinessApi,
):BusinessRepository {

    override suspend fun getBusiness(location: String, category: String): Flow<PagingData<Businesse>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                BusinessPagingSource(service, location, category)
            }
        ).flow
    }

}