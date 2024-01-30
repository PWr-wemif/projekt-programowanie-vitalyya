package com.project.schedule.utils

import com.project.schedule.models.WeekInfo
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class CalendarUtil {
    var calendar: Calendar = Calendar.getInstance()
    var move =0

    init{
        calendar.time = Date()
    }

    fun getTodayIndex(): Int {
        calendar.time = Date()
        return calendar.get(Calendar.DAY_OF_WEEK)-1
    }

    fun getWeekDays(): String {
        val sdf: DateFormat = SimpleDateFormat("dd-MM-yyyy")

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        val monday = sdf.format(calendar.time)

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        val friday = sdf.format(calendar.time)

        return "$monday - $friday"
    }

    fun getWeekInfo(): WeekInfo {

        val weekNumber = calendar.get(Calendar.WEEK_OF_YEAR)

        val sdf: DateFormat = SimpleDateFormat("dd-MM-yyyy")

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        val monday = sdf.format(calendar.time)

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        val friday = sdf.format(calendar.time)

        return WeekInfo(
            number = weekNumber,
            even = if(weekNumber%2==0){1}else{0},
            evenString = if(weekNumber%2==0){"even"}else{"odd"},
            weekString = "$monday - $friday"
        )


    }

    fun changeWeek(next: Boolean) {
        println(next)
        if(next){
            move+=7
        }else{
            move-=7

        }
        calendar.add(Calendar.DATE,move)
        println(calendar.time)

    }
}