package br.pprojects.blockchainapp.data.network

import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.model.remote.ChartResponse
import br.pprojects.blockchainapp.data.model.remote.PoolInfo
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ApiService {
    @GET("charts/transactions-per-second")
    fun listXYChartInfo(
        @Query("timespan") timespan: String,
        @Query("start") start: String?
    ): Call<ChartResponse>

    @GET("stats")
    fun getStatsInfo(): Call<StatsInfo>

    @GET("pools")
    fun getPoolInfo(
        @Query("timespan") timespan: String
    ): Call<PoolInfo>

    companion object {
        fun create(): ApiService {
            val retrofit = RetrofitManager()
            return retrofit.build().create(ApiService::class.java)
        }
    }
}