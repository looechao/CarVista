package com.example.cardemo

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.cardemo.adapter.LogoAdapter
import com.example.cardemo.bean.LogoBean
import com.example.cardemo.bean.Result
import com.example.cardemo.databinding.ActivityLogoBinding
import com.example.cardemo.utils.CarApi
import com.example.cardemo.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Response

class LogoActivity : AppCompatActivity() {

    val binding:ActivityLogoBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_logo)
    }

    val mDatas = mutableListOf<Result>()
    val adaper: LogoAdapter by lazy {
        LogoAdapter(this, mDatas)
    }

    var letter_msg = "当前品牌首字母:"
    var letter = "A"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.adapter = adaper
        binding.name = letter_msg+letter
        loadDatas(letter)
        binding.logoBtn.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                val lt = binding.logoEt.text.toString().trim()
                if(!TextUtils.isEmpty(lt) && !lt.equals(letter)){
                    letter = lt
                    binding.name = letter_msg + letter
                    loadDatas(letter)
                }
            }
        })
    }

    private fun loadDatas(letter: String) {
        //调用网络请求工具完成调用
        val api = RetrofitUtils.getApi(CarApi.base_url, CarApi::class.java)
        val call = api.getCarLogo(CarApi.key, letter)
        call?.enqueue(object : retrofit2.Callback<LogoBean> {
            override fun onResponse(call: Call<LogoBean>, response: Response<LogoBean>) {
                val bean: LogoBean? = response.body()
                mDatas.clear()
                adaper.addDatas(bean?.result)
            }

            override fun onFailure(call: Call<LogoBean>, t: Throwable) {

            }
        })
    }


}