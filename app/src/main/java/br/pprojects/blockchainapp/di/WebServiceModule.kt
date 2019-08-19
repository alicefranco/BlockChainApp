package br.pprojects.blockchainapp.di

import br.pprojects.blockchainapp.data.repository.remote.WebServiceRepository
import br.pprojects.blockchainapp.data.repository.remote.WebServiceRepositoryImpl
import org.koin.dsl.module

val webServiceModule = module {
    single<WebServiceRepository> { WebServiceRepositoryImpl(get()) }
}