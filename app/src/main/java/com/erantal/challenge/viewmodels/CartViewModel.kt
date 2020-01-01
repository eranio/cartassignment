package com.erantal.challenge.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erantal.challenge.models.RestShoppingCart
import com.erantal.challenge.rest.RestService
import com.erantal.challenge.rest.RetrofitClient
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CartViewModel : ViewModel() {
    var cartLiveData = MutableLiveData<RestShoppingCart>()
    var cart = RestShoppingCart()

    fun init() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        val service = RetrofitClient.getRestService
        val call = service?.getShoppingCart()
        handleResponse(call)
    }

    private fun handleResponse(call: Call<RestShoppingCart>?) {
        call?.enqueue(object : Callback<RestShoppingCart> {
            override fun onFailure(call: Call<RestShoppingCart>, t: Throwable) {
                Log.d("FAIL","Failed")
            }

            override fun onResponse(
                call: Call<RestShoppingCart>,
                response: Response<RestShoppingCart>
            ) {
                if (response.code() == 200) {
                    cart = response.body() ?: RestShoppingCart()
                    cartLiveData.postValue(cart)
                }
            }
        })
    }

}