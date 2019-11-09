package com.android.airbag

import android.app.Application
import com.android.airbag.di.getModules
import com.android.airbag.helpers.Constants
import com.android.airbag.network.Network
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AirBagApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Network.init(Constants.BASE_URL,BuildConfig.DEBUG)

        startKoin {
            this@AirBagApp
            androidContext(this@AirBagApp)
            modules(*getModules())
        }


    }
}