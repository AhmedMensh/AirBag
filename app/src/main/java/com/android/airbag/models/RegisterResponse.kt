package com.android.airbag.models


import com.squareup.moshi.Json

data class RegisterResponse(
    @Json(name = "avatar")
    val avatar: String? = null,
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "first_name")
    val firstName: String? = null,
    @Json(name = "last_name")
    val lastName: String? = null,
    @Json(name = "nickname")
    val nickname: String? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "phone_country")
    val phoneCountry: String? = null,
    @Json(name = "role")
    val role: String? = null,
    @Json(name = "role_id")
    val roleId: Int? = null,
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "token")
    val token: String? = null,
    @Json(name = "uuid")
    val uuid: String? = null
)