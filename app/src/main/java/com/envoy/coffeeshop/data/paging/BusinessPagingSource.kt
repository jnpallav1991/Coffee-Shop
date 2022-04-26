package com.envoy.coffeeshop.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.envoy.coffeeshop.data.model.Businesse
import com.envoy.coffeeshop.data.service.BusinessApi

const val NETWORK_PAGE_SIZE = 10
private const val INITIAL_LOAD_SIZE = 0

class BusinessPagingSource(
    private val service: BusinessApi,
    private val location: String,
    private val category: String
) : PagingSource<Int, Businesse>() {

    override fun getRefreshKey(state: PagingState<Int, Businesse>): Int {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Businesse> {

        val position = params.key ?: 1
        val offset =
            if (params.key != null) (NETWORK_PAGE_SIZE * position) - NETWORK_PAGE_SIZE else INITIAL_LOAD_SIZE
        return try {
            Log.d("debug paging", ""+params.loadSize+" "+offset+" "+position)
            val jsonResponse = service.getBusiness(location, category, 10, offset)
            val pagedResponse = jsonResponse.body()
            val data = pagedResponse?.businesses
            val nextKey = if (data == null) {
                null
            } else {
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (10 / NETWORK_PAGE_SIZE)
            }
            Log.d("debug paging", nextKey.toString())
            LoadResult.Page(

                data = data.orEmpty(),
                prevKey = null, // Only paging forward.
                // assume that if a full page is not loaded, that means the end of the data
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}