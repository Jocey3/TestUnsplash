package com.dev.jocey.testunsplash.api

import com.dev.jocey.testunsplash.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiManagerInstance {
    var apiService: ApiService? = null
    private var mRetrofit: Retrofit? = null

    init {
        initRetrofit(getHttpClient())
        apiService = mRetrofit?.create(ApiService::class.java)
    }

    private fun initRetrofit(httpClient: OkHttpClient) {
        mRetrofit = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(
                Interceptor { chain ->
                    val authToken: String = Constants.API_TOKEN
                    val request = chain.request().newBuilder()
                        .addHeader("Accept-Version", "Accept-Version: v1")
                        .addHeader("Authorization", "Client-ID $authToken")
                        .build()
                    chain.proceed(request)
                })
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}