package com.example.cardemo.adapter

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cardemo.R
import com.squareup.picasso.Picasso


//单例模式
object ImageViewBindingAdapter {

    @BindingAdapter("itemImage")
    @JvmStatic
    fun setImage(iv: ImageView, url: String){
        //picaso图片请求框架
        if (TextUtils.isEmpty(url)){
            iv.setImageResource(R.mipmap.cb)
        }else{
            Picasso.get()
                .load(url)
                .placeholder(R.mipmap.cb)
                .error(R.mipmap.cb)
                .into(iv)
        }
    }
}