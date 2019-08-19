package br.pprojects.blockchainapp.data.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.model.remote.ResultAPI
import br.pprojects.blockchainapp.data.repository.local.DatabaseRepository
import org.koin.core.KoinComponent

interface BitCoinInfoRepository {
    suspend fun getStatsInfo(): LiveData<StatsInfo>
}

class BitcoinInfoRepositoryImpl(
    private val databaseRepository: DatabaseRepository,
    private val webServiceRepository: WebServiceRepository
) : BitCoinInfoRepository, KoinComponent {
    override suspend fun getStatsInfo(): LiveData<StatsInfo> {
        val data: MutableLiveData<StatsInfo> = MutableLiveData()
        val response = getStatsInfoFromWebService()
        when (response) {
            is ResultAPI.Success -> {
                data.postValue(response.data)
                // insertStatsInfo(response.data)
            }
            is ResultAPI.InternalError -> {
                // todo error
            }
            is ResultAPI.Error -> {
                // todo error
            }
        }
        return data
    }

    suspend fun getStatsInfoFromDatabase(timestamp: Long): LiveData<StatsInfo> {
        return databaseRepository.getStatsInfoByTimespan(timestamp)
    }

    suspend fun getStatsInfoFromWebService(): ResultAPI<StatsInfo> {
        return webServiceRepository.getStatsInfo()
    }

    suspend fun getAllStatsInfo(): LiveData<List<StatsInfo>> {
        return databaseRepository.getAll()
    }

    suspend fun insertStatsInfo(statsInfo: StatsInfo) {
        return databaseRepository.insert(statsInfo)
    }
}