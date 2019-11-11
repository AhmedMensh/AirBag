package com.android.airbag.network

import com.android.airbag.models.ActiveUser
import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.network.ApiService


class RemoteDataSource(private val api: ApiService) {

    suspend fun register(registerBody: RegisterBody) = safeApiCall {
        api.register(registerBody)
    }

    suspend fun login(loginBody: LoginBody) = safeApiCall{
        api.login(loginBody)
    }

    suspend fun activeUser(activeUser: ActiveUser) = safeApiCall { api.activeUser(activeUser) }

    suspend fun resetPassword(email : String) = safeApiCall { api.resetPassword(email) }
}
