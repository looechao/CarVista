package com.example.cardemo.bean

data class BrandListBean(
    val error_code: Int,
    val reason: String,
    val result: List<BrandResult>
)

data class BrandResult(
    val brandid: String,
    val id: String,
    val levelid: String,
    val levelname: String,
    val name: String,
    val sname: String
)