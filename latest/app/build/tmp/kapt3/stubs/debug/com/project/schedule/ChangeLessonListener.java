package com.project.schedule;

import com.project.schedule.models.Lesson;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/project/schedule/ChangeLessonListener;", "", "cancelTask", "", "createNewLesson", "lesson", "Lcom/project/schedule/models/Lesson;", "setUpdateLesson", "Scheduler_1.0_debug"})
public abstract interface ChangeLessonListener {
    
    public abstract void setUpdateLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson);
    
    public abstract void createNewLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson);
    
    public abstract void cancelTask();
}