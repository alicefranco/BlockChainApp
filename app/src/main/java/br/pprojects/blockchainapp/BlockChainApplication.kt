package br.pprojects.blockchainapp

import android.app.Application
import br.pprojects.blockchainapp.di.bitCoinInfoModule
import br.pprojects.blockchainapp.di.configModule
import br.pprojects.blockchainapp.di.databaseModule
import br.pprojects.blockchainapp.di.webServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlockChainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlockChainApplication)
            modules(listOf(
                configModule,
                bitCoinInfoModule,
                webServiceModule,
                databaseModule))
        }
    }
}