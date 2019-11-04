package com.android.airbag.repositories

import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import sa.amaz.jaz.student.models.DataResult

interface IAirBagRepo {

    suspend fun register(registerBody: RegisterBody) : DataResult<RegisterResponse>
    suspend fun login(loginBody: LoginBody) : DataResult<RegisterResponse>
}