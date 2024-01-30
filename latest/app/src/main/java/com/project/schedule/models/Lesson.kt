package com.project.schedule.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lessons")
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "day_of_week")
    val dayOfWeek: Int,
    @ColumnInfo(name = "week_even")
    val weekEven: Int,
    @ColumnInfo(name = "time_start_hours")
    val timeStartHours: Int,
    @ColumnInfo(name = "time_start_mins")
    val timeStartMins: Int,
    @ColumnInfo(name = "time_end_hours")
    val timeEndHours: Int,
    @ColumnInfo(name = "time_end_min")
    val timeEndMin: Int,
    val name: String,
    val address: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeInt(dayOfWeek)
        parcel.writeInt(weekEven)
        parcel.writeInt(timeStartHours)
        parcel.writeInt(timeStartMins)
        parcel.writeInt(timeEndHours)
        parcel.writeInt(timeEndMin)
        parcel.writeString(name)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        val num = 0
        return num
    }

    override fun toString(): String {
        return "Lesson(id=$id, dayOfWeek=$dayOfWeek, weekEven=$weekEven, timeStartHours=$timeStartHours, timeStartMins=$timeStartMins, timeEndHours=$timeEndHours, timeEndMin=$timeEndMin, name='$name', address='$address')"
    }


    companion object CREATOR : Parcelable.Creator<Lesson> {
        override fun createFromParcel(parcel: Parcel): Lesson {
            return Lesson(parcel)
        }

        override fun newArray(size: Int): Array<Lesson?> {
            return arrayOfNulls(size)
        }
    }




}