package com.android.airbag.ui.activities.reset_password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.airbag.models.DataResult
import com.android.airbag.repositories.IAirBagRepo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResetPasswordViewModel(private val iAirBagRepo: IAirBagRepo) : ViewModel() {

    var error = MutableLiveData<String>()

    fun resetPassword(email : String) : LiveData<Boolean>{

        var data = MutableLiveData<Boolean>()

        viewModelScope.launch {
            when(val result = withContext(IO) {iAirBagRepo.resetPassword(email)}){
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