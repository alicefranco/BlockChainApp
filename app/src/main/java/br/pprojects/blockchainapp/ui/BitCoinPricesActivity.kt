package br.pprojects.blockchainapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.pprojects.blockchainapp.R
import kotlinx.android.synthetic.main.activity_bitcoin_prices.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.pprojects.blockchainapp.utils.getDate
import br.pprojects.blockchainapp.utils.getTime

class BitCoinPricesActivity : AppCompatActivity() {
    private val bitcoinPricesViewModel: BitcoinPricesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitcoin_prices)

        bitcoinPricesViewModel.stats.observe(this, Observer { stats ->
            tvPrice.text = stats.marketPriceUsd.toString()
            stats.timestamp?.let {
                tvDate.text = it.getDate()
                tvTime.text = it.getTime()
            }
        })
    }
}
