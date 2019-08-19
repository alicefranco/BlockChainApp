package br.pprojects.blockchainapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.repository.remote.BitCoinInfoRepository
import br.pprojects.blockchainapp.utils.scheduleTask
import kotlinx.coroutines.*

class BitcoinPricesViewModel (private val bitCoinInfoRepository: BitCoinInfoRepository) : ViewModel() {
    var stats: LiveData<StatsInfo> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()
    private val timeInterval: Long = 2*60*1000

    init {
        scheduleTask(timeInterval, { getStats() })
    }

    fun getStats(){
        CoroutineScope(Dispatchers.Main).launch {
            loading.value = true
            stats = bitCoinInfoRepository.getStatsInfo()
            loading.value = false
        }
    }

    fun getLoading() : LiveData<Boolean> {
        return loading
    }

    fun getError() : LiveData<String> {
        return error
    }
}
