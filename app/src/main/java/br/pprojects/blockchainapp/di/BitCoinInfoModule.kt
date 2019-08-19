package br.pprojects.blockchainapp.di

import br.pprojects.blockchainapp.data.repository.remote.BitCoinInfoRepository
import br.pprojects.blockchainapp.data.repository.remote.BitcoinInfoRepositoryImpl
import br.pprojects.blockchainapp.ui.BitcoinPricesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bitCoinInfoModule = module {
    single<BitCoinInfoRepository> { BitcoinInfoRepositoryImpl(get(), get()) }

    viewModel { BitcoinPricesViewModel(get(), get()) }
}