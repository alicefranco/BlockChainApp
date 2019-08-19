package br.pprojects.blockchainapp.data.repository.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.pprojects.blockchainapp.data.database.BitCoinInfoDao
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent

interface DatabaseRepository {
    suspend fun insert(statsInfo: StatsInfo)
    suspend fun insertAll(statsList: List<StatsInfo>)
    suspend fun getAll(): LiveData<List<StatsInfo>>
    suspend fun getStatsInfoByTimespan(timestamp: Long):  LiveData<StatsInfo>
    suspend fun delete(statsInfo: StatsInfo)
}

class DatabaseBaseRepositoryImpl(private val bitCoinInfoDao: BitCoinInfoDao): DatabaseRepository, KoinComponent {
    override suspend fun insertAll(statsList: List<StatsInfo>) {
        withContext(Dispatchers.IO) {
            bitCoinInfoDao.insertAll(statsList)
        }
    }

    override suspend fun getAll(): LiveData<List<StatsInfo>> {
        val data: MutableLiveData<List<StatsInfo>> = MutableLiveData()
        data.value =  withContext(Dispatchers.IO) { bitCoinInfoDao.getAll() }
        return data
    }

    override suspend fun getStatsInfoByTimespan(timestamp: Long): LiveData<StatsInfo> {
        val data: MutableLiveData<StatsInfo> = MutableLiveData()
        data.value = withContext(Dispatchers.IO) { bitCoinInfoDao.getStatsInfoByTimespan(timestamp) }
        return data
    }

    override suspend fun delete(statsInfo: StatsInfo) {
        withContext(Dispatchers.IO) {
            bitCoinInfoDao.delete(statsInfo)
        }
    }

    override suspend fun insert(statsInfo: StatsInfo) {
        withContext(Dispatchers.IO) {
            bitCoinInfoDao.insert(statsInfo)
        }
    }
}