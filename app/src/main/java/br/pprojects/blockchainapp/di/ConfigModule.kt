package br.pprojects.blockchainapp.di

import androidx.room.Room
import br.pprojects.blockchainapp.data.database.AppDatabase
import br.pprojects.blockchainapp.data.network.ApiService
import br.pprojects.blockchainapp.data.network.RetrofitManager
import br.pprojects.blockchainapp.utils.Constants
import org.koin.dsl.module

val configModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
    }

    single { get<AppDatabase>().bitCoinInfoDao() }
    single { RetrofitManager() }
    single { ApiService.create() }
}