package com.project.schedule.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.schedule.models.Lesson

@Database(
    version = 1,
    entities = [Lesson::class]
)

abstract class AppDb: RoomDatabase() {
    abstract fun getLessonDao(): LessonDao
}