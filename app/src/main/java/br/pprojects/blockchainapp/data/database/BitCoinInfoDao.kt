package br.pprojects.blockchainapp.data.database

import androidx.room.*
import br.pprojects.blockchainapp.data.model.remote.StatsInfo

@Dao
interface BitCoinInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(statsInfo: StatsInfo)

    @Insert
    fun insertAll(statsList: List<StatsInfo>)

    @Query("SELECT * FROM statsinfo")
    fun getAll(): List<StatsInfo>

    @Query("SELECT * FROM statsinfo WHERE timestamp = :timestamp")
    fun getStatsInfoByTimespan(timestamp: Long): StatsInfo

    @Delete
    fun delete(statsInfo: StatsInfo)
}