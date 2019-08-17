package br.pprojects.blockchainapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.pprojects.blockchainapp.R
import br.pprojects.blockchainapp.data.repository.remote.BitCoinInfoRepository
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val chartRepo: BitCoinInfoRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
