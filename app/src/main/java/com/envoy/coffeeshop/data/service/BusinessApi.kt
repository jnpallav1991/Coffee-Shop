package com.envoy.coffeeshop.data.service

import com.envoy.coffeeshop.data.model.Business
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BusinessApi {
    @GET("businesses/search")
    suspend fun getBusiness(
        @Query("location") location: String,
        @Query("categories") categories: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<Business>
}