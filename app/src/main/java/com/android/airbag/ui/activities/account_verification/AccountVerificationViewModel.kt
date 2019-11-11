package com.android.airbag.ui.activities.account_verification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.airbag.models.ActiveUser
import com.android.airbag.repositories.IAirBagRepo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.android.airbag.models.DataResult

class AccountVerificationViewModel(private val iAirBagRepo: IAirBagRepo) : ViewModel() {

    var error = MutableLiveData<String>()

    fun activeUser(activeUser: ActiveUser) : LiveData<Boolean>{
        var data = MutableLiveData<Boolean>()

        viewModelScope.launch {
            when(val result = withContext(IO) { iAirBagRepo.activeUser(activeUser)}){

                is DataResult.Success ->{
                    error.value = null
                    data.value = result.content

                }
                is DataResult.Error -> {
                    data.value = null
                    error.value = result.exception.message
                }
            }
        }
        return data
    }

}

