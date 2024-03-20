package com.training.newsretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.training.newsretrofitdemo.Constants.API_KEY
import com.training.newsretrofitdemo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView(){
        apiService= RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        apiService.getNews("tesla","2024-02-20","publishedAt",API_KEY).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                Log.i("tag","${response.body()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("tag","${t.message}")
            }
        })
    }
}