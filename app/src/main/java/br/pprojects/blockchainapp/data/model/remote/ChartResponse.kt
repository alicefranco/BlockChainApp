package br.pprojects.blockchainapp.data.model.remote

import br.pprojects.blockchainapp.data.model.local.PointValue
import com.google.gson.annotations.SerializedName

data class ChartResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("unit") var unit: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("values") var values: List<PointValue>? = null
)
