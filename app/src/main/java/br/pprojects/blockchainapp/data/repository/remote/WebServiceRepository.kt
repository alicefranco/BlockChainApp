package br.pprojects.blockchainapp.data.repository.remote

import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.model.remote.TransactionsPerSecondChartResponse
import br.pprojects.blockchainapp.data.model.remote.PoolInfo
import br.pprojects.blockchainapp.data.model.remote.ResultAPI
import br.pprojects.blockchainapp.data.network.ApiService
import br.pprojects.blockchainapp.utils.result
import br.pprojects.blockchainapp.utils.safeCall
import org.koin.core.KoinComponent

interface WebServiceRepository {
    suspend fun listTransactionsPerSecondChartInfo(timespan: String, start: String? = ""): ResultAPI<TransactionsPerSecondChartResponse>
    suspend fun getStatsInfo(): ResultAPI<StatsInfo>
    suspend fun getPoolInfo(timespan: String): ResultAPI<PoolInfo>
}


class WebServiceRepositoryImpl(private val apiService: ApiService): WebServiceRepository, KoinComponent {
    override suspend fun listTransactionsPerSecondChartInfo(timespan: String, start: String?): ResultAPI<TransactionsPerSecondChartResponse> {
        val response = safeCall { apiService.listTransactionsPerSecondChartInfo(timespan, start) }
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