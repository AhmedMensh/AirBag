package com.android.airbag.network

import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.network.Network.REQUIRE_AUTHENTICATION
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import sa.amaz.jaz.student.models.ApiResponse


interface ApiService {

    @POST("auth/register")
    suspend fun register(@Body registerBody: RegisterBody) : ApiResponse<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body loginBody: LoginBody) : ApiResponse<RegisterResponse>

//    @Headers("$REQUIRE_AUTHENTICATION: true")
//    @PUT("auth/activeUser")
}
