package br.pprojects.blockchainapp.di

import br.pprojects.blockchainapp.data.network.ApiService
import br.pprojects.blockchainapp.data.network.RetrofitManager
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitManager() }
    single { ApiService.create() }
}