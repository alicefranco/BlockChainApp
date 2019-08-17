package br.pprojects.blockchainapp.data.model.remote

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.sql.Timestamp

data class StatsInfo (
    @SerializedName("market_price_usd") var marketPriceUsd: BigDecimal?,
    @SerializedName("hash_rate") var hashRate: BigDecimal?,
    @SerializedName("total_fees_btc") var totalFeesBtc: BigDecimal?,
    @SerializedName("n_btc_mined") var nBtcMined: BigDecimal?,
    @SerializedName("n_tx") var nTx: BigDecimal?,
    @SerializedName("n_blocks_mined") var nBlocksMined: BigDecimal?,
    @SerializedName("minutes_between_blocks") var minutesBetweenBlocks: BigDecimal?,
    @SerializedName("totalbc") var totalBc: BigDecimal?,
    @SerializedName("n_blocks_total") var nBlocksTotal: BigDecimal?,
    @SerializedName("estimated_transaction_volume_usd") var estimatedTransactionVolumeUsd: BigDecimal?,
    @SerializedName("blocks_size") var blocksSize: BigDecimal?,
    @SerializedName("miners_revenue_usd") var minersRevenueUsd: BigDecimal?,
    @SerializedName("nextretarget") var nextRetarget: BigDecimal?,
    @SerializedName("difficulty") var difficulty: BigDecimal?,
    @SerializedName("estimated_btc_sent") var estimatedBtcSent: BigDecimal?,
    @SerializedName("miners_revenue_btc") var minersRevenueBtc: BigDecimal?,
    @SerializedName("total_btc_sent") var totalBtcFees: BigDecimal?,
    @SerializedName("trade_volume_btc") var tradeVolumeBtc: BigDecimal?,
    @SerializedName("trade_volume_usd") var tradeVolumeUsd: BigDecimal?,
    @SerializedName("timestamp") var timestamp: Long?
)
