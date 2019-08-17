package br.pprojects.blockchainapp.data.model.local

import com.google.gson.annotations.SerializedName

data class PointValue(
    @SerializedName("x") var x: Double? = null,
    @SerializedName("y") var y: Double? = null
)