package com.project.schedule.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.room.ColumnInfo;
import com.project.schedule.ChangeLessonListener;
import com.project.schedule.R;
import com.project.schedule.db.AppDb;
import com.project.schedule.models.Lesson;
import com.project.schedule.models.LessonOnUI;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J&\u0010J\u001a\u0004\u0018\u00010F2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u000209H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u00102\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u000e\u00105\u001a\u000206X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010)\"\u0004\b<\u0010+R\u001a\u0010=\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+R\u001a\u0010@\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010)\"\u0004\bB\u0010+\u00a8\u0006R"}, d2 = {"Lcom/project/schedule/fragments/ChangeLessonFragment;", "Landroidx/fragment/app/Fragment;", "()V", "cancelBt", "Landroid/widget/Button;", "getCancelBt", "()Landroid/widget/Button;", "setCancelBt", "(Landroid/widget/Button;)V", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "getChangeLessonListener", "()Lcom/project/schedule/ChangeLessonListener;", "setChangeLessonListener", "(Lcom/project/schedule/ChangeLessonListener;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dayOfWeekInput", "Landroid/widget/Spinner;", "getDayOfWeekInput", "()Landroid/widget/Spinner;", "setDayOfWeekInput", "(Landroid/widget/Spinner;)V", "db", "Lcom/project/schedule/db/AppDb;", "getDb", "()Lcom/project/schedule/db/AppDb;", "setDb", "(Lcom/project/schedule/db/AppDb;)V", "editBt", "getEditBt", "setEditBt", "editHead", "Landroid/widget/TextView;", "getEditHead", "()Landroid/widget/TextView;", "setEditHead", "(Landroid/widget/TextView;)V", "endHoursInput", "Landroid/widget/EditText;", "getEndHoursInput", "()Landroid/widget/EditText;", "setEndHoursInput", "(Landroid/widget/EditText;)V", "endMinsInput", "getEndMinsInput", "setEndMinsInput", "errorMsg", "getErrorMsg", "setErrorMsg", "evenWeekInput", "getEvenWeekInput", "setEvenWeekInput", "id", "", "lessonML", "Landroidx/lifecycle/MutableLiveData;", "Lcom/project/schedule/models/Lesson;", "lessonNameInput", "getLessonNameInput", "setLessonNameInput", "startHoursInput", "getStartHoursInput", "setStartHoursInput", "startMinsInput", "getStartMinsInput", "setStartMinsInput", "initUi", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setLessonFromBaseToUi", "it", "Companion", "Scheduler_1.0_debug"})
public final class ChangeLessonFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject
    public com.project.schedule.db.AppDb db;
    private long id = 0L;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.CoroutineScope coroutineScope;
    public android.widget.TextView editHead;
    public android.widget.Spinner evenWeekInput;
    public android.widget.Spinner dayOfWeekInput;
    public android.widget.EditText startHoursInput;
    public android.widget.EditText startMinsInput;
    public android.widget.EditText endHoursInput;
    public android.widget.EditText endMinsInput;
    public android.widget.EditText lessonNameInput;
    public android.widget.TextView errorMsg;
    public android.widget.Button editBt;
    public android.widget.Button cancelBt;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<com.project.schedule.models.Lesson> lessonML;
    public com.project.schedule.ChangeLessonListener changeLessonListener;
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.ChangeLessonFragment.Companion Companion = null;
    
    public ChangeLessonFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.db.AppDb getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull
    com.project.schedule.db.AppDb p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getEditHead() {
        return null;
    }
    
    public final void setEditHead(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Spinner getEvenWeekInput() {
        return null;
    }
    
    public final void setEvenWeekInput(@org.jetbrains.annotations.NotNull
    android.widget.Spinner p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Spinner getDayOfWeekInput() {
        return null;
    }
    
    public final void setDayOfWeekInput(@org.jetbrains.annotations.NotNull
    android.widget.Spinner p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getStartHoursInput() {
        return null;
    }
    
    public final void setStartHoursInput(@org.jetbrains.annotations.NotNull
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getStartMinsInput() {
        return null;
    }
    
    public final void setStartMinsInput(@org.jetbrains.annotations.NotNull
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getEndHoursInput() {
        return null;
    }
    
    public final void setEndHoursInput(@org.jetbrains.annotations.NotNull
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getEndMinsInput() {
        return null;
    }
    
    public final void setEndMinsInput(@org.jetbrains.annotations.NotNull
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText getLessonNameInput() {
        return null;
    }
    
    public final void setLessonNameInput(@org.jetbrains.annotations.NotNull
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getErrorMsg() {
        return null;
    }
    
    public final void setErrorMsg(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getEditBt() {
        return null;
    }
    
    public final void setEditBt(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getCancelBt() {
        return null;
    }
    
    public final void setCancelBt(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.ChangeLessonListener getChangeLessonListener() {
        return null;
    }
    
    public final void setChangeLessonListener(@org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initUi(android.view.View view) {
    }
    
    private final void setLessonFromBaseToUi(com.project.schedule.models.Lesson it) {
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.ChangeLessonFragment newInstance(long id, @org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener changeLessonListener) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/project/schedule/fragments/ChangeLessonFragment$Companion;", "", "()V", "newInstance", "Lcom/project/schedule/fragments/ChangeLessonFragment;", "id", "", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "Scheduler_1.0_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final com.project.schedule.fragments.ChangeLessonFragment newInstance(long id, @org.jetbrains.annotations.NotNull
        com.project.schedule.ChangeLessonListener changeLessonListener) {
            return null;
        }
    }
}