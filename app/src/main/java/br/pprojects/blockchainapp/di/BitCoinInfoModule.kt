package br.pprojects.blockchainapp.di

import br.pprojects.blockchainapp.data.repository.remote.BitCoinInfoRepository
import br.pprojects.blockchainapp.data.repository.remote.BitcoinInfoRepositoryImpl
import org.koin.dsl.module

val bitCoinInfoModule = module {
    single<BitCoinInfoRepository>{ BitcoinInfoRepositoryImpl(get()) }
}