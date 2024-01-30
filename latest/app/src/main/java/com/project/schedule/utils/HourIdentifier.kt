package com.project.schedule.utils

import android.view.View
import android.widget.TextView
import com.project.schedule.models.Hour

class HourIdentifier(val view: View) {
    fun makeHours(listIds: Array<Int>): ArrayList<Hour> {

        val hours = arrayListOf<Hour>()

        hours.add(Hour()) //0
        hours.add(Hour()) //1
        hours.add(Hour()) //2
        hours.add(Hour()) //3
        hours.add(Hour()) //4
        hours.add(Hour()) //5
        hours.add(Hour()) //6
        hours.add(Hour()) //7

        val hour8 = Hour(
            view.findViewById<TextView>(listIds.get(0)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(1)),
                view.findViewById<TextView>(listIds.get(2)),
                view.findViewById<TextView>(listIds.get(3)),
                view.findViewById<TextView>(listIds.get(4))
            )
        )
        hours.add(hour8)

        val hour9 = Hour(
            view.findViewById<TextView>(listIds.get(5)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(6)),
                view.findViewById<TextView>(listIds.get(7)),
                view.findViewById<TextView>(listIds.get(8)),
                view.findViewById<TextView>(listIds.get(9))
            )
        )
        hours.add(hour9)

        val hour10 = Hour(
            view.findViewById<TextView>(listIds.get(10)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(11)),
                view.findViewById<TextView>(listIds.get(12)),
                view.findViewById<TextView>(listIds.get(13)),
                view.findViewById<TextView>(listIds.get(14))
            )
        )
        hours.add(hour10)

        val hour11 = Hour(
            view.findViewById<TextView>(listIds.get(15)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(16)),
                view.findViewById<TextView>(listIds.get(17)),
                view.findViewById<TextView>(listIds.get(18)),
                view.findViewById<TextView>(listIds.get(19))
            )
        )
        hours.add(hour11)

        val hour12 = Hour(
            view.findViewById<TextView>(listIds.get(20)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(21)),
                view.findViewById<TextView>(listIds.get(22)),
                view.findViewById<TextView>(listIds.get(23)),
                view.findViewById<TextView>(listIds.get(24))
            )
        )
        hours.add(hour12)

        val hour13 = Hour(
            view.findViewById<TextView>(listIds.get(25)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(26)),
                view.findViewById<TextView>(listIds.get(27)),
                view.findViewById<TextView>(listIds.get(28)),
                view.findViewById<TextView>(listIds.get(29))
            )
        )
        hours.add(hour13)

        val hour14 = Hour(
            view.findViewById<TextView>(listIds.get(30)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(31)),
                view.findViewById<TextView>(listIds.get(32)),
                view.findViewById<TextView>(listIds.get(33)),
                view.findViewById<TextView>(listIds.get(34))
            )
        )
        hours.add(hour14)

        val hour15 = Hour(
            view.findViewById<TextView>(listIds.get(35)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(36)),
                view.findViewById<TextView>(listIds.get(37)),
                view.findViewById<TextView>(listIds.get(38)),
                view.findViewById<TextView>(listIds.get(39))
            )
        )
        hours.add(hour15)

        val hour16 = Hour(
            view.findViewById<TextView>(listIds.get(40)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(41)),
                view.findViewById<TextView>(listIds.get(42)),
                view.findViewById<TextView>(listIds.get(43)),
                view.findViewById<TextView>(listIds.get(44))
            )
        )
        hours.add(hour16)

        val hour17 = Hour(
            view.findViewById<TextView>(listIds.get(45)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(46)),
                view.findViewById<TextView>(listIds.get(47)),
                view.findViewById<TextView>(listIds.get(48)),
                view.findViewById<TextView>(listIds.get(49))
            )
        )
        hours.add(hour17)

        val hour18 = Hour(
            view.findViewById<TextView>(listIds.get(50)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(51)),
                view.findViewById<TextView>(listIds.get(52)),
                view.findViewById<TextView>(listIds.get(53)),
                view.findViewById<TextView>(listIds.get(54))
            )
        )
        hours.add(hour18)

        val hour19 = Hour(
            view.findViewById<TextView>(listIds.get(55)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(56)),
                view.findViewById<TextView>(listIds.get(57)),
                view.findViewById<TextView>(listIds.get(58)),
                view.findViewById<TextView>(listIds.get(59))
            )
        )
        hours.add(hour19)

        val hour20 = Hour(
            view.findViewById<TextView>(listIds.get(60)),
            arrayOf(
                view.findViewById<TextView>(listIds.get(61)),
                view.findViewById<TextView>(listIds.get(62)),
                view.findViewById<TextView>(listIds.get(63)),
                view.findViewById<TextView>(listIds.get(64))
            )
        )
        hours.add(hour20)

        hours.add(Hour())//21
        hours.add(Hour())//22
        hours.add(Hour())//23


        return hours
    }
}