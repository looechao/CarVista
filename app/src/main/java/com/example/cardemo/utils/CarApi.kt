package com.example.cardemo.utils

import android.telecom.Call
import android.util.Log
import com.example.cardemo.bean.BrandListBean
import com.example.cardemo.bean.BrandResult
import com.example.cardemo.bean.LogoBean
import com.example.cardemo.bean.ModelListBean
import com.example.cardemo.bean.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface CarApi {

    //可以直接用类名来调用
    companion object {
        val key = "1532549052195884fd01d89db414ec52"
        val base_url = "http://apis.juhe.cn/cxdq/"
    }

    @GET("brand")
    open fun getCarLogo(@Query("key") key:String,
                        @Query("first_letter") first_letter:String): retrofit2.Call<LogoBean>?
    @GET("series")
    open fun getCarSeries(@Query("key") key:String,
                        @Query("brandid") first_letter:String): retrofit2.Call<BrandListBean>?

    @GET("models")
    open fun getModelList(@Query("key") key:String,
                          @Query("series_id") first_letter:String): retrofit2.Call<ModelListBean>?
}