package br.pprojects.blockchainapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.pprojects.blockchainapp.R
import kotlinx.android.synthetic.main.activity_bitcoin_prices.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.pprojects.blockchainapp.utils.getDate
import br.pprojects.blockchainapp.utils.getTime
import com.jjoe64.graphview.series.DataPoint
import java.sql.Date

class BitCoinPricesActivity : AppCompatActivity() {
    private lateinit var graph: Graph
    private val bitcoinPricesViewModel: BitcoinPricesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitcoin_prices)

        graph = Graph(graphView)
        graph.configureGraph(this)

        bitcoinPricesViewModel.stats.observe(this, Observer { stats ->
            tvPrice.text = stats.marketPriceUsd.toString()
            stats.timestamp.let {
                tvDate.text = it.getDate()
                tvTime.text = it.getTime()
            }
        })

        bitcoinPricesViewModel.statsList.observe(this, Observer { statsList ->
            statsList.forEach {
                val price = it.marketPriceUsd
                val timestamp = it.timestamp

                val dataPoint = DataPoint(Date(timestamp), price.toDouble())
                graph.addPoint(dataPoint)
            }
        })

        bitcoinPricesViewModel.error.observe(this, Observer {
            tvError.text = it
            showError(true)
        })

        bitcoinPricesViewModel.loading.observe(this, Observer {
            showProgress(it)
        })

        bitcoinPricesViewModel.loadingRefresh.observe(this, Observer {
            showProgressRefresh(it)
        })

        ivRefresh.setOnClickListener {
            showProgress(true)
            bitcoinPricesViewModel.getStats()
        }
    }

    fun showError(show: Boolean) {
        if (show == null) {
            errorLayout.visibility = View.GONE
            tvError.visibility = View.GONE
            ivRefresh.visibility = View.GONE
        } else {
            errorLayout.visibility = View.VISIBLE
            tvError.visibility = View.VISIBLE
            ivRefresh.visibility = View.VISIBLE
        }
    }

    fun showProgress(show: Boolean) {
        if (show) {
            errorLayout.visibility = View.VISIBLE
            tvError.visibility = View.GONE
            ivRefresh.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        } else {
            errorLayout.visibility = View.GONE
            tvError.visibility = View.GONE
            ivRefresh.visibility = View.GONE
            progressBar.visibility = View.GONE
        }
    }
    fun showProgressRefresh(show: Boolean) {
        if (show) {
            // ivRefresh.visibility = View.GONE
            progressBarRefresh.visibility = View.VISIBLE
        } else {
            // ivRefresh.visibility = View.GONE
            progressBarRefresh.visibility = View.GONE
        }
    }
}
