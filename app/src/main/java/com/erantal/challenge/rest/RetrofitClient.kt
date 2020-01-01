package com.erantal.challenge.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance: Retrofit? = null
    private val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    val getRestService: RestService?
        get() {
          if (instance == null)
              instance = Retrofit.Builder()
                  .baseUrl(RestService.BASE_URL)
                  .client(client)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
            return instance?.create(RestService::class.java)
    }
}