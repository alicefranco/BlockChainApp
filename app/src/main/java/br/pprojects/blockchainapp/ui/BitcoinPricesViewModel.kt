package br.pprojects.blockchainapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pprojects.blockchainapp.data.model.remote.ResultAPI
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.data.repository.local.DatabaseRepository
import br.pprojects.blockchainapp.data.repository.remote.WebServiceRepository
import br.pprojects.blockchainapp.utils.scheduleTask
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BitcoinPricesViewModel(
    private val webServiceRepository: WebServiceRepository,
    private val databaseRepository: DatabaseRepository
) : ViewModel() {
    var stats: MutableLiveData<StatsInfo> = MutableLiveData()
    var statsList: LiveData<List<StatsInfo>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val loadingRefresh: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
    private val timeInterval: Long = 2 * 60 * 1000
    private var init = true

    init {
        scheduleTask(timeInterval, { getStats() })
        getAllStats()
    }

    fun getStats() {
        CoroutineScope(Dispatchers.Main).launch {
            if (init == true) {
                loading.value = true
                init = false
            } else {
                loadingRefresh.value = true
            }
            val response = webServiceRepository.getStatsInfo()
            loading.value = false
            loadingRefresh.value = false

            when (response) {
                is ResultAPI.Success -> {
                    stats.value = response.data
                    databaseRepository.insert(response.data)
                }
                is ResultAPI.InternalError -> {
                    if (init == true)
                        error.value = "Por favor, cheque sua conexão com a internet."
                }
                is ResultAPI.Error -> {
                    if (init == true)
                        error.value = "Ocorreu um erro. Por favor, tente novamente."
                }
            }
        }
    }

    fun getAllStats() {
        loading.value = true
        statsList = databaseRepository.getAll()
        loading.value = false
    }
}
