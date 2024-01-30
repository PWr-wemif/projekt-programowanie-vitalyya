package com.project.schedule.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.project.schedule.ChangeLessonListener;
import com.project.schedule.utils.HourIdentifier;
import com.project.schedule.LessonListener;
import com.project.schedule.R;
import com.project.schedule.models.Hour;
import com.project.schedule.models.Lesson;
import com.project.schedule.models.LessonOnUI;
import com.project.schedule.utils.GsonUtil;
import com.project.schedule.utils.TimeToViewUtil;
import com.project.schedule.views.LessonView;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

/**
 * A simple [Fragment] subclass.
 * Use the [DayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0014\u0010A\u001a\u0002082\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0010\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020<H\u0002J\u0006\u0010E\u001a\u000208R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0016j\b\u0012\u0004\u0012\u00020!`\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/project/schedule/fragments/DayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "getChangeLessonListener", "()Lcom/project/schedule/ChangeLessonListener;", "setChangeLessonListener", "(Lcom/project/schedule/ChangeLessonListener;)V", "gsonUtil", "Lcom/project/schedule/utils/GsonUtil;", "getGsonUtil", "()Lcom/project/schedule/utils/GsonUtil;", "setGsonUtil", "(Lcom/project/schedule/utils/GsonUtil;)V", "lessonListener", "Lcom/project/schedule/LessonListener;", "getLessonListener", "()Lcom/project/schedule/LessonListener;", "setLessonListener", "(Lcom/project/schedule/LessonListener;)V", "listAddedLessons", "Ljava/util/ArrayList;", "Lcom/project/schedule/models/LessonOnUI;", "Lkotlin/collections/ArrayList;", "listLessons", "", "Lcom/project/schedule/models/Lesson;", "getListLessons", "()Ljava/util/List;", "setListLessons", "(Ljava/util/List;)V", "listTv", "Lcom/project/schedule/models/Hour;", "getListTv", "()Ljava/util/ArrayList;", "setListTv", "(Ljava/util/ArrayList;)V", "mainLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMainLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMainLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "timeToViewUtil", "Lcom/project/schedule/utils/TimeToViewUtil;", "checkForFreeSpace", "", "startX", "", "startY", "endY", "lessonHeight", "", "lessonWidth", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setList", "list", "setUI", "view", "workUI", "Companion", "Scheduler_1.0_debug"})
public final class DayFragment extends androidx.fragment.app.Fragment {
    public com.project.schedule.LessonListener lessonListener;
    public com.project.schedule.ChangeLessonListener changeLessonListener;
    public java.util.List<com.project.schedule.models.Lesson> listLessons;
    @javax.inject.Inject
    public com.project.schedule.utils.GsonUtil gsonUtil;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.project.schedule.models.LessonOnUI> listAddedLessons;
    public androidx.constraintlayout.widget.ConstraintLayout mainLayout;
    public java.util.ArrayList<com.project.schedule.models.Hour> listTv;
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.utils.TimeToViewUtil timeToViewUtil = null;
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.DayFragment.Companion Companion = null;
    
    public DayFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.LessonListener getLessonListener() {
        return null;
    }
    
    public final void setLessonListener(@org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.ChangeLessonListener getChangeLessonListener() {
        return null;
    }
    
    public final void setChangeLessonListener(@org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.project.schedule.models.Lesson> getListLessons() {
        return null;
    }
    
    public final void setListLessons(@org.jetbrains.annotations.NotNull
    java.util.List<com.project.schedule.models.Lesson> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.utils.GsonUtil getGsonUtil() {
        return null;
    }
    
    public final void setGsonUtil(@org.jetbrains.annotations.NotNull
    com.project.schedule.utils.GsonUtil p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.constraintlayout.widget.ConstraintLayout getMainLayout() {
        return null;
    }
    
    public final void setMainLayout(@org.jetbrains.annotations.NotNull
    androidx.constraintlayout.widget.ConstraintLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.project.schedule.models.Hour> getListTv() {
        return null;
    }
    
    public final void setListTv(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.project.schedule.models.Hour> p0) {
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
    
    private final void setUI(android.view.View view) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.List<com.project.schedule.models.Lesson> list) {
    }
    
    public final void workUI() {
    }
    
    private final boolean checkForFreeSpace(float startX, float startY, float endY, int lessonHeight, int lessonWidth) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.DayFragment newInstance(@org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener changeLessonListener) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/project/schedule/fragments/DayFragment$Companion;", "", "()V", "newInstance", "Lcom/project/schedule/fragments/DayFragment;", "lessonListener", "Lcom/project/schedule/LessonListener;", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "Scheduler_1.0_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final com.project.schedule.fragments.DayFragment newInstance(@org.jetbrains.annotations.NotNull
        com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
        com.project.schedule.ChangeLessonListener changeLessonListener) {
            return null;
        }
    }
}