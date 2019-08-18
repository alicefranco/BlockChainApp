package br.pprojects.blockchainapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pprojects.blockchainapp.data.model.remote.ResultAPI
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.repository.remote.BitCoinInfoRepository
import br.pprojects.blockchainapp.utils.scheduleTask
import kotlinx.coroutines.*

class BitcoinPricesViewModel (private val bitCoinInfoRepository: BitCoinInfoRepository) : ViewModel() {

    val stats: MutableLiveData<StatsInfo> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()
    private val timeInterval: Long = 2*60*1000

    init {
        scheduleTask(timeInterval, { getStats() })
    }

    fun getStats(){
        GlobalScope.launch (Dispatchers.Main) {
            loading.value = true
            val response = withContext(Dispatchers.IO){ bitCoinInfoRepository.getStatsInfo()}
            loading.value = false
            when(response){
                is ResultAPI.Success -> {
                    stats.value = response.data
                    error.value = ""
                }
                is ResultAPI.Error -> {
                    error.value = "Ocorre um erro. Por favor tente novamente."
                }
                is ResultAPI.InternalError -> {
                    error.value = "Por favor, cheque sua conexão com a internet e tente novamente."
                }
            }
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
