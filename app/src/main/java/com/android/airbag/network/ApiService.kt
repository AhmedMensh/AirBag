package com.android.airbag.network

import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST
import sa.amaz.jaz.student.models.ApiResponse


interface ApiService {

    @POST("auth/register")
    suspend fun register(@Body registerBody: RegisterBody) : ApiResponse<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body loginBody: LoginBody) : ApiResponse<RegisterResponse>

}
