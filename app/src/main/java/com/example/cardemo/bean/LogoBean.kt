package com.example.cardemo.bean

data class LogoBean(
    val error_code: Int,
    val reason: String,
    val result: List<Result>
)

data class Result(
    val brand_logo: String,
    val brand_name: String,
    val first_letter: String,
    val id: String
)