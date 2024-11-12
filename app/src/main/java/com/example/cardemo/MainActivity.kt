package com.example.cardemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btn1: Button
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn1 = findViewById(R.id.main_btn1)
        btn2 = findViewById(R.id.main_btn2)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            btn1 -> {}  //新闻
            btn2 -> {   //品牌大全
                startActivity(Intent(this, LogoActivity::class.java))
            }
            else -> {}
        }
    }
}