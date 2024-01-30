package com.project.schedule.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.project.schedule.models.Lesson

@Dao
interface LessonDao {

    @Insert(entity = Lesson::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertNewLesson(lesson: Lesson)

    @Update(entity = Lesson::class)
    fun updateLesson(lesson: Lesson)

    @Query("SELECT * FROM lessons WHERE day_of_week=:day AND week_even = :weekEven")
    fun getLessonByDayAndWeek(day: Int, weekEven: Int): List<Lesson>

    @Query("SELECT * FROM lessons WHERE id=:id")
    fun getLessonById(id: Long): Lesson

    @Query("DELETE FROM lessons WHERE id = :id")
    fun deleteLessonById(id: Long)


}