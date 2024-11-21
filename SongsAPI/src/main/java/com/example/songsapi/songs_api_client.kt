package com.example.songsapi

import com.example.songsapi.apis.SongsAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object SongsAPIClient {
    private const val BASE_URL = "https://api.musixmatch.com/ws/1.1/"
    private const val API_KEY = "8dbbbf65ba63d8e5278851222fc09948"

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(
                Interceptor {
                    val original = it.request()
                    val originalHttpUrl = original.url()

                    val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", API_KEY)
                        .build()

                    val request = original.newBuilder()
                        .url(url)
                        .build()

                    it.proceed(request)
                }
            ).build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api : SongsAPI by lazy {
        retrofit.create(SongsAPI::class.java)
    }
}