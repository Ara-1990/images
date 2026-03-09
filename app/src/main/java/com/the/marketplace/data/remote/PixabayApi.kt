package com.the.marketplace.data.remote

import com.the.marketplace.BuildConfig
import com.the.marketplace.data.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
  @GET("api/")
  suspend fun searchImages(
      @Query("key")key: String = BuildConfig.PIXABAY_API_KEY,
      @Query("q") query: String
  ):PixabayResponse
}