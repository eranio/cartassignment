package com.erantal.challenge.rest

import com.erantal.challenge.models.RestProduct
import com.erantal.challenge.models.RestShoppingCart
import retrofit2.Call
import retrofit2.http.GET


interface RestService {
    companion object {
        const val BASE_URL = "http://www.mocky.io"
    }

    @GET("/v2/59c791ed1100005300c39b93")
    fun getShoppingCart(): Call<RestShoppingCart>
}