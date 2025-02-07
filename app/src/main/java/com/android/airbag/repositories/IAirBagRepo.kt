package com.android.airbag.repositories

import com.android.airbag.models.ActiveUser
import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.models.DataResult

interface IAirBagRepo {

    suspend fun register(registerBody: RegisterBody) : DataResult<RegisterResponse>
    suspend fun login(loginBody: LoginBody) : DataResult<RegisterResponse>
    suspend fun activeUser(activeUser: ActiveUser) : DataResult<Boolean>
    suspend fun resetPassword(email: String) : DataResult<Boolean>
}