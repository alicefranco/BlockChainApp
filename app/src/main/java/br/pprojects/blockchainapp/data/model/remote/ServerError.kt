package br.pprojects.blockchainapp.data.model.remote

import com.google.gson.annotations.SerializedName

data class ServerError(
    @SerializedName("error_detail") val errorDetail: String?,
    @SerializedName("error_description") val errorDescription: String?
)