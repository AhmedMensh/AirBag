package com.android.airbag.network

import com.android.airbag.models.ActiveUser
import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.network.Network.REQUIRE_AUTHENTICATION
import retrofit2.http.*
import sa.amaz.jaz.student.models.ApiResponse


interface ApiService {

    @POST("auth/register")
    suspend fun register(@Body registerBody: RegisterBody) : ApiResponse<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body loginBody: LoginBody) : ApiResponse<RegisterResponse>

    @Headers("$REQUIRE_AUTHENTICATION: true")
    @PUT("auth/activeUser")
    suspend fun activeUser(@Body activeUser: ActiveUser) : ApiResponse<ActiveUser>

    @FormUrlEncoded
    @POST("auth/resetPassword")
    suspend fun resetPassword(@Field("email") email : String) : ApiResponse<Boolean>
}
