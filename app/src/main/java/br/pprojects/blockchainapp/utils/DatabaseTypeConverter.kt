package br.pprojects.blockchainapp.utils

import androidx.room.TypeConverter
import java.math.BigDecimal

class DatabaseTypeConverter {

    @TypeConverter
    fun toBigDecimal(value: Long?): BigDecimal? {
        return if (value == null) null
            else BigDecimal(value)
    }

    @TypeConverter
    fun toLong(value: BigDecimal?): Long? {
        return  value?.toLong()
    }
}