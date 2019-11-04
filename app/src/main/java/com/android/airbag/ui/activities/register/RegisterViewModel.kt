package com.android.airbag.ui.activities.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.airbag.models.RegisterBody
import com.android.airbag.models.RegisterResponse
import com.android.airbag.repositories.IAirBagRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sa.amaz.jaz.student.models.DataResult

class RegisterViewModel(private val iAirBagRepo: IAirBagRepo) : ViewModel() {

    var error  = MutableLiveData<String>()

    fun register(registerBody: RegisterBody) : LiveData<RegisterResponse>{
        val data :MutableLiveData<RegisterResponse> = MutableLiveData()

        viewModelScope.launch {
            val result = withContext(IO) { iAirBagRepo.register(registerBody)}
            when(result){
                is DataResult.Success -> {
                    data.value = result.content
                }
                is DataResult.Error -> {
                    error.value = result.exception.message
                }
            }
        }
        return data
    }

}

