package ru.k.kbook.auth.v1.util

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
object Timer {
    fun now(): LocalDateTime {
        val nowInstant = Clock.System.now()
        val systemTimeZone = TimeZone.currentSystemDefault()
        val currentLocalDateTime = nowInstant.toLocalDateTime(systemTimeZone)
        return currentLocalDateTime
    }
}
