package com.android.airbag.models

import com.squareup.moshi.Json

data class ApiError(
    @field:Json(name = "message")
    val message : String?,
    @field:Json(name = "success")
    val success: Boolean?
)