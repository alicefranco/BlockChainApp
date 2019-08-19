package br.pprojects.blockchainapp.di

import br.pprojects.blockchainapp.data.repository.local.DatabaseBaseRepositoryImpl
import br.pprojects.blockchainapp.data.repository.local.DatabaseRepository
import org.koin.dsl.module

val databaseModule = module {
    single<DatabaseRepository> {
        DatabaseBaseRepositoryImpl(
            get()
        )
    }
}