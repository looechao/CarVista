package com.example.cardemo.bean

data class ModelListBean(
    val error_code: Int,
    val reason: String,
    val result: List<Result>
)

data class ModelResult(
    val id: String,
    val name: String,
    val peizhi: String,
    val series_id: String,
    val year: String
)