package br.pprojects.blockchainapp.utils

import androidx.lifecycle.ViewModel
import java.sql.Timestamp
import java.util.*

fun Long?.getDate() = this?.let {
    val timestamp = Timestamp(it)
    timestamp.toString().split(" ")[0]
}

fun Long?.getTime() = this?.let {
    val timestamp = Timestamp(it)
    timestamp.toString().split(" ")[1].removeSuffix(".0")
}

fun scheduleTask(delay: Long, task: () -> Unit) {
    val timer = Timer()
    val execution = object : TimerTask() {
        override fun run() {
            task()
        }
    }
    timer.schedule(execution, 0, delay)
}

