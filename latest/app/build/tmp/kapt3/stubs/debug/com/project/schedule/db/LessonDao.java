package com.project.schedule.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.project.schedule.models.Lesson;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\'J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/project/schedule/db/LessonDao;", "", "deleteLessonById", "", "id", "", "getLessonByDayAndWeek", "", "Lcom/project/schedule/models/Lesson;", "day", "", "weekEven", "getLessonById", "insertNewLesson", "lesson", "updateLesson", "Scheduler_1.0_debug"})
@androidx.room.Dao
public abstract interface LessonDao {
    
    @androidx.room.Insert(entity = com.project.schedule.models.Lesson.class, onConflict = 1)
    public abstract void insertNewLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson);
    
    @androidx.room.Update(entity = com.project.schedule.models.Lesson.class)
    public abstract void updateLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson);
    
    @androidx.room.Query(value = "SELECT * FROM lessons WHERE day_of_week=:day AND week_even = :weekEven")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.project.schedule.models.Lesson> getLessonByDayAndWeek(int day, int weekEven);
    
    @androidx.room.Query(value = "SELECT * FROM lessons WHERE id=:id")
    @org.jetbrains.annotations.NotNull
    public abstract com.project.schedule.models.Lesson getLessonById(long id);
    
    @androidx.room.Query(value = "DELETE FROM lessons WHERE id = :id")
    public abstract void deleteLessonById(long id);
}