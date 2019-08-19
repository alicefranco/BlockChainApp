package br.pprojects.blockchainapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.pprojects.blockchainapp.data.model.remote.StatsInfo
import br.pprojects.blockchainapp.utils.Constants
import br.pprojects.blockchainapp.utils.DatabaseTypeConverter
import org.koin.core.KoinComponent

@TypeConverters(DatabaseTypeConverter::class)
@Database(entities = arrayOf(StatsInfo::class), version = Constants.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase(), KoinComponent {
    abstract fun bitCoinInfoDao(): BitCoinInfoDao
}