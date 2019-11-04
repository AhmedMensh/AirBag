package com.android.airbag.models


import com.squareup.moshi.Json

data class RegisterBody(
    @Json(name = "confirm_password")
    var confirmPassword: String? = null,
    @Json(name = "email")
    var email: String? = null,
    @Json(name = "first_name")
    var firstName: String? = null,
    @Json(name = "last_name")
    var lastName: String? = null,
    @Json(name = "nickname")
    var nickname: String? = null,
    @Json(name = "password")
    var password: String? = null,
    @Json(name = "phone")
    var phone: String? = null,
    @Json(name = "phone_country")
    var phoneCountry: String? = null
)