package com.android.airbag.models


import com.squareup.moshi.Json

data class LoginBody(

        @Json(name = "email")
        var email: String? = null,

        @Json(name = "password")
        var password: String? = null

)