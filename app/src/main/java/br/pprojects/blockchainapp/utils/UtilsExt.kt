package br.pprojects.blockchainapp.utils

import java.sql.Timestamp

fun Long?.getDate() = this?.let {
    val timestamp = Timestamp(it)
    timestamp.toString().split(" ")[0]
}

fun Long?.getTime() = this?.let {
    val timestamp = Timestamp(it)
    timestamp.toString().split(" ")[1].removeSuffix(".0")
}
