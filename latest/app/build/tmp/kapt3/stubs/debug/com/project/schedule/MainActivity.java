package com.project.schedule;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import com.project.schedule.fragments.ChangeLessonFragment;
import com.project.schedule.fragments.MainFragment;
import com.project.schedule.fragments.MessageFragment;
import com.project.schedule.models.Lesson;
import com.project.schedule.repository.LessonRepository;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001bJ\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u001dH\u0014J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010-\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/project/schedule/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/project/schedule/LessonListener;", "Lcom/project/schedule/ChangeLessonListener;", "()V", "TIME_INTERVAL", "", "baseUpdate", "Landroidx/lifecycle/MutableLiveData;", "", "getBaseUpdate", "()Landroidx/lifecycle/MutableLiveData;", "setBaseUpdate", "(Landroidx/lifecycle/MutableLiveData;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "lessonRepository", "Lcom/project/schedule/repository/LessonRepository;", "getLessonRepository", "()Lcom/project/schedule/repository/LessonRepository;", "setLessonRepository", "(Lcom/project/schedule/repository/LessonRepository;)V", "mBackPressed", "", "cancelTask", "", "closeMessage", "createNewLesson", "lesson", "Lcom/project/schedule/models/Lesson;", "deleteLesson", "id", "deleteLessonById", "editLesson", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setExit", "setMainFragment", "setUpdateLesson", "updateDayFragment", "Scheduler_1.0_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.project.schedule.LessonListener, com.project.schedule.ChangeLessonListener {
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.CoroutineScope coroutineScope;
    @javax.inject.Inject
    public com.project.schedule.repository.LessonRepository lessonRepository;
    private final int TIME_INTERVAL = 3000;
    private long mBackPressed = 0L;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> baseUpdate;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineScope getCoroutineScope() {
        return null;
    }
    
    public final void setCoroutineScope(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.repository.LessonRepository getLessonRepository() {
        return null;
    }
    
    public final void setLessonRepository(@org.jetbrains.annotations.NotNull
    com.project.schedule.repository.LessonRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getBaseUpdate() {
        return null;
    }
    
    public final void setBaseUpdate(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void setExit() {
    }
    
    private final void updateDayFragment() {
    }
    
    private final void setMainFragment() {
    }
    
    @java.lang.Override
    public void editLesson(long id) {
    }
    
    @java.lang.Override
    public void deleteLesson(long id) {
    }
    
    private final void closeMessage() {
    }
    
    public final void deleteLessonById(long id) {
    }
    
    @java.lang.Override
    public void setUpdateLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
    }
    
    @java.lang.Override
    public void createNewLesson(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.Lesson lesson) {
    }
    
    @java.lang.Override
    public void cancelTask() {
    }
}