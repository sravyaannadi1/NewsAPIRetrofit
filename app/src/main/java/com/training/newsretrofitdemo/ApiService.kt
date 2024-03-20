package com.training.newsretrofitdemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.NEW_ENDPOINT)
    fun getNews(
        @Query("q")q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
        ): Call<NewsResponse>
}