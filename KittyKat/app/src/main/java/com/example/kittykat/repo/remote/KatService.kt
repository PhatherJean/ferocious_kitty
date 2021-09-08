package com.example.kittykat.repo.remote

import com.example.kittykat.model.Kat
import com.example.kittykat.utils.Order
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KatService {
    @Headers("x-api-key: 3e5237e2-e13e-4d67-2e90addd5bf3")
    @GET("v1/images/search")
    suspend fun getKatImages(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: Order
    ) : Response<List<Kat>>
}