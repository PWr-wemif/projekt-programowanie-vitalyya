package com.project.schedule.models

data class TimeToViewModel (
    val indexHoursStart: Int,
    val indexMinutesStart: Int,
    val indexHoursEnd: Int,
    val indexMinutesEnd: Int
){
    override fun toString(): String {
        return "TimeToViewModel(indexHoursStart=$indexHoursStart, indexMinutesStart=$indexMinutesStart, indexHoursEnd=$indexHoursEnd, indexMinutesEnd=$indexMinutesEnd)"
    }
}

