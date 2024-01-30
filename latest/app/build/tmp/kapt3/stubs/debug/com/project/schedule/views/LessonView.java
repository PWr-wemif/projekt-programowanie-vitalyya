package com.project.schedule.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.project.schedule.LessonListener;
import com.project.schedule.R;
import com.project.schedule.models.Lesson;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0016\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\b\u0010*\u001a\u00020\'H\u0014J\u0018\u0010+\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/project/schedule/views/LessonView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "lessonListener", "Lcom/project/schedule/LessonListener;", "lesson", "Lcom/project/schedule/models/Lesson;", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/project/schedule/LessonListener;Lcom/project/schedule/models/Lesson;)V", "delete", "Landroid/widget/ImageView;", "getDelete", "()Landroid/widget/ImageView;", "setDelete", "(Landroid/widget/ImageView;)V", "edit", "getEdit", "setEdit", "getLesson", "()Lcom/project/schedule/models/Lesson;", "getLessonListener", "()Lcom/project/schedule/LessonListener;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "time", "getTime", "setTime", "view", "Landroid/view/View;", "changeViewSize", "", "newWidth", "newHeight", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Scheduler_1.0_debug"})
public final class LessonView extends android.widget.LinearLayout {
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.LessonListener lessonListener = null;
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.models.Lesson lesson = null;
    @org.jetbrains.annotations.NotNull
    private final android.view.View view = null;
    public android.widget.TextView time;
    public android.widget.TextView name;
    public android.widget.ImageView edit;
    public android.widget.ImageView delete;
    
    @kotlin.jvm.JvmOverloads
    public LessonView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes, @org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.LessonListener getLessonListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.models.Lesson getLesson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getEdit() {
        return null;
    }
    
    public final void setEdit(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getDelete() {
        return null;
    }
    
    public final void setDelete(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @java.lang.Override
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    public final void changeViewSize(int newWidth, int newHeight) {
    }
    
    @kotlin.jvm.JvmOverloads
    public LessonView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr, @org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public LessonView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, @org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public LessonView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
        super(null);
    }
}