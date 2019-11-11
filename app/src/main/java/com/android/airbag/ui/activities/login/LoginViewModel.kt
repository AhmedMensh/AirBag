package com.android.airbag.ui.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.airbag.models.LoginBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.repositories.IAirBagRepo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.android.airbag.models.DataResult

class LoginViewModel(private val iAirBagRepo: IAirBagRepo) : ViewModel() {

    var error  = MutableLiveData<String>()

    fun login(loginBody: LoginBody) : LiveData<RegisterResponse>{
        val data :MutableLiveData<RegisterResponse> = MutableLiveData()

        viewModelScope.launch {
            val result = withContext(IO) { iAirBagRepo.login(loginBody)}
            when(result){
                is DataResult.Success -> {
                    data.value = result.content
                    error.value = null
                }
                is DataResult.Error -> {
                    error.value = result.exception.message
                    data.value = null
                }
            }
        }
        return data
    }

}

