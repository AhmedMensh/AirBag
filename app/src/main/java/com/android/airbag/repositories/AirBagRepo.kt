package com.android.airbag.repositories

import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.network.RemoteDataSource
import sa.amaz.jaz.student.models.DataResult

class AirBagRepo(private val remoteDataSource: RemoteDataSource) : IAirBagRepo {


    override suspend fun login(loginBody: LoginBody): DataResult<RegisterResponse> {

        return when(val result = remoteDataSource.login(loginBody)){
            is DataResult.Success ->{
                val data = result.content
                DataResult.Success(data)
            }
            is DataResult.Error -> return DataResult.Error(result.exception)
        }
    }

    override suspend fun register(registerBody: RegisterBody): DataResult<RegisterResponse> {
        return when(val result = remoteDataSource.register(registerBody)){
            is DataResult.Success ->{
                val data = result.content
                DataResult.Success(data)
            }
            is DataResult.Error -> return DataResult.Error(result.exception)
        }
    }
}