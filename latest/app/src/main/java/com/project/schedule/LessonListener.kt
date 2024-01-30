package com.project.schedule

interface LessonListener {
    fun editLesson(id: Long)

    fun deleteLesson(id: Long)
}