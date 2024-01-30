package com.project.schedule

import com.project.schedule.models.Lesson

interface ChangeLessonListener {
    fun setUpdateLesson(lesson: Lesson)
    fun createNewLesson(lesson: Lesson)
    fun cancelTask()
}