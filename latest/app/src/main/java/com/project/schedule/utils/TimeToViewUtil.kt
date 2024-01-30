package com.project.schedule.utils

import com.project.schedule.models.TimeToViewModel
import kotlin.math.min

class TimeToViewUtil {


    fun convertInfo(
        hoursStart: Int,
        minutesStart: Int,
        hoursEnd: Int,
        minutesEnd: Int
    ): TimeToViewModel {
        var indexHoursStart = 0
        var indexMinutesStart = 0
        var indexHoursEnd = 0
        var indexMinutesEnd = 0


        indexHoursStart = getHoursIndex(hoursStart)
        indexHoursEnd = getHoursIndex(hoursEnd)


        indexMinutesStart = getMinutesIndex(minutesStart, false)

        indexMinutesEnd = getMinutesIndex(minutesEnd, true)

        if (indexMinutesEnd == 3) {
            indexHoursEnd += 1
            indexMinutesEnd = 0
        }else if(indexMinutesEnd==-1){
            indexMinutesEnd=0
        }
        else{
            indexMinutesEnd +=1
        }
        return TimeToViewModel(indexHoursStart, indexMinutesStart, indexHoursEnd, indexMinutesEnd)
    }

    private fun getMinutesIndex(minutesStart: Int, end: Boolean): Int {

        if(end && minutesStart == 0){
            return -1
        }

        if (minutesStart in 0..14) {
            return 0
        } else if (minutesStart in 15..29) {
            return 1
        } else if (minutesStart in 30..44) {
            return 2
        } else {
            return 3
        }

    }

    private fun getHoursIndex(hours: Int): Int {
        return hours
    }
}