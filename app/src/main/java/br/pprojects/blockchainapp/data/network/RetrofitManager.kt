package br.pprojects.blockchainapp.data.network

import br.pprojects.blockchainapp.utils.Constants
import org.koin.core.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager : KoinComponent {
    fun build(): Retrofit {
        val clientInterceptor = ClientInterceptor()
            .createClient()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientInterceptor)
            .build()
    }
}