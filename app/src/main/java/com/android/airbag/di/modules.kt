package com.android.airbag.di

import com.android.airbag.network.Network
import com.android.airbag.network.RemoteDataSource
import com.android.airbag.repositories.AirBagRepo
import com.android.airbag.repositories.IAirBagRepo
import com.android.airbag.ui.activities.login.LoginViewModel
import com.android.airbag.ui.activities.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val network = module { factory { Network.apiService } }

private val remoteModule = module { factory {  RemoteDataSource(get()) } }

private var repositoryModule = module {

    single<IAirBagRepo> {AirBagRepo(get() ,get())}
}

private val viewModelModule = module {
    viewModel { RegisterViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}

fun getModules() : Array<Module>{

    return arrayOf(
            network,
            remoteModule,
            repositoryModule,
            viewModelModule
    )
}