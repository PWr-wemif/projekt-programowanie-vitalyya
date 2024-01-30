package com.project.schedule.repository;

import com.project.schedule.db.AppDb;
import com.project.schedule.models.Lesson;
import com.project.schedule.db.LessonDao;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/project/schedule/repository/LessonRepository;", "", "appDb", "Lcom/project/schedule/db/AppDb;", "(Lcom/project/schedule/db/AppDb;)V", "deleteLessonById", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLessonByDayAndWeek", "", "Lcom/project/schedule/models/Lesson;", "day", "", "weekEven", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNewLesson", "lesson", "(Lcom/project/schedule/models/Lesson;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLesson", "Scheduler_1.0_debug"})
public final class LessonRepository {
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.db.AppDb appDb = null;
    
    public LessonRepository(@org.jetbrains.annotations.NotNull
    com.project.schedule.db.AppDb appDb) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertNewLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLessonByDayAndWeek(int day, int weekEven, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.project.schedule.models.Lesson>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteLessonById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}