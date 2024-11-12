package com.example.cardemo.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Retrofit的单例对象
object RetrofitUtils {
    private var retrofit:Retrofit? = null

    fun getRetrofit(base_url: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit!!  //不能为空加!!，可以为空加?
    }

    //泛型
    fun <T>getApi(base_url: String, cls: Class<T>): T {
        val retrofit = getRetrofit(base_url)
        return retrofit.create(cls)
    }
}