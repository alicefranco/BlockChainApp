package br.pprojects.blockchainapp.data.repository.remote

import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.model.remote.ChartResponse
import br.pprojects.blockchainapp.data.model.remote.PoolInfo
import br.pprojects.blockchainapp.data.model.remote.ResultAPI
import br.pprojects.blockchainapp.data.network.ApiService
import br.pprojects.blockchainapp.utils.result
import br.pprojects.blockchainapp.utils.safeCall
import org.koin.core.KoinComponent

interface BitCoinInfoRepository {
    suspend fun listXYChartInfo(timespan: String, start: String? = ""): ResultAPI<ChartResponse>
    suspend fun getStatsInfo(): ResultAPI<StatsInfo>
    suspend fun getPoolInfo(timespan: String): ResultAPI<PoolInfo>
}


class BitcoinInfoRepositoryImpl(private val apiService: ApiService): BitCoinInfoRepository, KoinComponent {
    override suspend fun listXYChartInfo(timespan: String, start: String?): ResultAPI<ChartResponse> {
        val response = safeCall { apiService.listXYChartInfo(timespan, start) }
        return response.result()
    }

    override suspend fun getStatsInfo(): ResultAPI<StatsInfo> {
        val response = safeCall { apiService.getStatsInfo() }
        return response.result()
    }

    override suspend fun getPoolInfo(timespan: String): ResultAPI<PoolInfo> {
        val response = safeCall { apiService.getPoolInfo(timespan) }
        return response.result()
    }

}