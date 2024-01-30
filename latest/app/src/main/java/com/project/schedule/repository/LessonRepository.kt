package com.project.schedule.repository

import com.project.schedule.db.AppDb
import com.project.schedule.models.Lesson
import com.project.schedule.db.LessonDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LessonRepository(private val appDb: AppDb) {
    suspend fun insertNewLesson(lesson: Lesson){
        withContext(Dispatchers.IO){
            appDb.getLessonDao().insertNewLesson(lesson)
        }
    }

    suspend fun getLessonByDayAndWeek(day: Int, weekEven: Int):List<Lesson>{
          return appDb.getLessonDao().getLessonByDayAndWeek(day, weekEven)
    }

    suspend fun deleteLessonById(id: Long){
        withContext(Dispatchers.IO){
            appDb.getLessonDao().deleteLessonById(id)
        }
    }

    suspend fun updateLesson(lesson: Lesson){
        withContext(Dispatchers.IO){
            appDb.getLessonDao().updateLesson(lesson)
        }
    }
}