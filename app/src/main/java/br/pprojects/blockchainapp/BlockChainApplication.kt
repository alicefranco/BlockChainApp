package br.pprojects.blockchainapp

import android.app.Application
import br.pprojects.blockchainapp.di.bitCoinInfoModule
import br.pprojects.blockchainapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlockChainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlockChainApplication)
            modules(listOf(networkModule, bitCoinInfoModule))
        }
    }
}