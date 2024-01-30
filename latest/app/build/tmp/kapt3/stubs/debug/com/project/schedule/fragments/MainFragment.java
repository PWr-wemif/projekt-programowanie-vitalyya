package com.project.schedule.fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.project.schedule.ChangeLessonListener;
import com.project.schedule.LessonListener;
import com.project.schedule.MainActivity;
import com.project.schedule.R;
import com.project.schedule.TabListener;
import com.project.schedule.db.AppDb;
import com.project.schedule.models.Lesson;
import com.project.schedule.models.WeekInfo;
import com.project.schedule.repository.LessonRepository;
import com.project.schedule.utils.CalendarUtil;
import com.project.schedule.utils.GsonUtil;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0002\u0082\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020_H\u0002J\u0012\u0010r\u001a\u00020n2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J&\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\b\u0010{\u001a\u00020nH\u0016J\u0010\u0010|\u001a\u00020n2\u0006\u0010}\u001a\u00020_H\u0016J\u0010\u0010~\u001a\u00020n2\u0006\u0010\u007f\u001a\u00020vH\u0002J\t\u0010\u0080\u0001\u001a\u00020nH\u0002J\u0007\u0010\u0081\u0001\u001a\u00020nR\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050403X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;X\u0082.\u00a2\u0006\u0004\n\u0002\u0010=R\u001a\u0010>\u001a\u00020?X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020?X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010A\"\u0004\bK\u0010CR\u001a\u0010L\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010F\"\u0004\bN\u0010HR\u001a\u0010O\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010F\"\u0004\bQ\u0010HR\u001a\u0010R\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010F\"\u0004\bT\u0010HR\u001a\u0010U\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010F\"\u0004\bW\u0010HR\u001a\u0010X\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010F\"\u0004\bZ\u0010HR\u001a\u0010[\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010F\"\u0004\b]\u0010HR\u001a\u0010^\u001a\u00020_X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010F\"\u0004\bl\u0010H\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/project/schedule/fragments/MainFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/project/schedule/TabListener;", "lessonListener", "Lcom/project/schedule/LessonListener;", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "(Lcom/project/schedule/LessonListener;Lcom/project/schedule/ChangeLessonListener;)V", "addButton", "Landroid/widget/Button;", "getAddButton", "()Landroid/widget/Button;", "setAddButton", "(Landroid/widget/Button;)V", "calendarUtil", "Lcom/project/schedule/utils/CalendarUtil;", "getCalendarUtil", "()Lcom/project/schedule/utils/CalendarUtil;", "setCalendarUtil", "(Lcom/project/schedule/utils/CalendarUtil;)V", "getChangeLessonListener", "()Lcom/project/schedule/ChangeLessonListener;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "db", "Lcom/project/schedule/db/AppDb;", "getDb", "()Lcom/project/schedule/db/AppDb;", "setDb", "(Lcom/project/schedule/db/AppDb;)V", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getFirebaseRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "setFirebaseRemoteConfig", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "gsonUtil", "Lcom/project/schedule/utils/GsonUtil;", "getGsonUtil", "()Lcom/project/schedule/utils/GsonUtil;", "setGsonUtil", "(Lcom/project/schedule/utils/GsonUtil;)V", "getLessonListener", "()Lcom/project/schedule/LessonListener;", "lessonRepository", "Lcom/project/schedule/repository/LessonRepository;", "getLessonRepository", "()Lcom/project/schedule/repository/LessonRepository;", "setLessonRepository", "(Lcom/project/schedule/repository/LessonRepository;)V", "list", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/project/schedule/models/Lesson;", "getList", "()Landroidx/lifecycle/MutableLiveData;", "setList", "(Landroidx/lifecycle/MutableLiveData;)V", "listButtons", "", "Landroid/widget/TextView;", "[Landroid/widget/TextView;", "nextBt", "Landroid/widget/ImageView;", "getNextBt", "()Landroid/widget/ImageView;", "setNextBt", "(Landroid/widget/ImageView;)V", "nextTv", "getNextTv", "()Landroid/widget/TextView;", "setNextTv", "(Landroid/widget/TextView;)V", "previousBt", "getPreviousBt", "setPreviousBt", "previousTv", "getPreviousTv", "setPreviousTv", "textViewFriday", "getTextViewFriday", "setTextViewFriday", "textViewMonday", "getTextViewMonday", "setTextViewMonday", "textViewThursday", "getTextViewThursday", "setTextViewThursday", "textViewTuesday", "getTextViewTuesday", "setTextViewTuesday", "textViewWednesday", "getTextViewWednesday", "setTextViewWednesday", "userTab", "", "getUserTab", "()I", "setUserTab", "(I)V", "weekInfo", "Lcom/project/schedule/models/WeekInfo;", "getWeekInfo", "()Lcom/project/schedule/models/WeekInfo;", "setWeekInfo", "(Lcom/project/schedule/models/WeekInfo;)V", "weekTv", "getWeekTv", "setWeekTv", "changeWeek", "", "next", "", "getIndexForTab", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "pressTab", "indexTab", "setUI", "view", "setWeek", "updateDay", "Companion", "Scheduler_1.0_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment implements com.project.schedule.TabListener {
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.LessonListener lessonListener = null;
    @org.jetbrains.annotations.NotNull
    private final com.project.schedule.ChangeLessonListener changeLessonListener = null;
    public android.widget.ImageView previousBt;
    public android.widget.TextView previousTv;
    public android.widget.TextView weekTv;
    public android.widget.ImageView nextBt;
    public android.widget.TextView nextTv;
    public android.widget.TextView textViewMonday;
    public android.widget.TextView textViewTuesday;
    public android.widget.TextView textViewWednesday;
    public android.widget.TextView textViewThursday;
    public android.widget.TextView textViewFriday;
    @javax.inject.Inject
    public com.project.schedule.utils.CalendarUtil calendarUtil;
    @javax.inject.Inject
    public com.project.schedule.repository.LessonRepository lessonRepository;
    @javax.inject.Inject
    public com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig;
    @javax.inject.Inject
    public com.project.schedule.db.AppDb db;
    @javax.inject.Inject
    public com.project.schedule.utils.GsonUtil gsonUtil;
    private int userTab = 1;
    private android.widget.TextView[] listButtons;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<com.project.schedule.models.Lesson>> list;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    public com.project.schedule.models.WeekInfo weekInfo;
    public android.widget.Button addButton;
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.MainFragment.Companion Companion = null;
    
    public MainFragment(@org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener changeLessonListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.LessonListener getLessonListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.ChangeLessonListener getChangeLessonListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getPreviousBt() {
        return null;
    }
    
    public final void setPreviousBt(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getPreviousTv() {
        return null;
    }
    
    public final void setPreviousTv(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getWeekTv() {
        return null;
    }
    
    public final void setWeekTv(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ImageView getNextBt() {
        return null;
    }
    
    public final void setNextBt(@org.jetbrains.annotations.NotNull
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getNextTv() {
        return null;
    }
    
    public final void setNextTv(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTextViewMonday() {
        return null;
    }
    
    public final void setTextViewMonday(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTextViewTuesday() {
        return null;
    }
    
    public final void setTextViewTuesday(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTextViewWednesday() {
        return null;
    }
    
    public final void setTextViewWednesday(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTextViewThursday() {
        return null;
    }
    
    public final void setTextViewThursday(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getTextViewFriday() {
        return null;
    }
    
    public final void setTextViewFriday(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.utils.CalendarUtil getCalendarUtil() {
        return null;
    }
    
    public final void setCalendarUtil(@org.jetbrains.annotations.NotNull
    com.project.schedule.utils.CalendarUtil p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.repository.LessonRepository getLessonRepository() {
        return null;
    }
    
    public final void setLessonRepository(@org.jetbrains.annotations.NotNull
    com.project.schedule.repository.LessonRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig getFirebaseRemoteConfig() {
        return null;
    }
    
    public final void setFirebaseRemoteConfig(@org.jetbrains.annotations.NotNull
    com.google.firebase.remoteconfig.FirebaseRemoteConfig p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.db.AppDb getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull
    com.project.schedule.db.AppDb p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.utils.GsonUtil getGsonUtil() {
        return null;
    }
    
    public final void setGsonUtil(@org.jetbrains.annotations.NotNull
    com.project.schedule.utils.GsonUtil p0) {
    }
    
    public final int getUserTab() {
        return 0;
    }
    
    public final void setUserTab(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.project.schedule.models.Lesson>> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.util.List<com.project.schedule.models.Lesson>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.models.WeekInfo getWeekInfo() {
        return null;
    }
    
    public final void setWeekInfo(@org.jetbrains.annotations.NotNull
    com.project.schedule.models.WeekInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getAddButton() {
        return null;
    }
    
    public final void setAddButton(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
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
    
    private final void changeWeek(boolean next) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final int getIndexForTab() {
        return 0;
    }
    
    private final void setWeek() {
    }
    
    @java.lang.Override
    public void pressTab(int indexTab) {
    }
    
    public final void updateDay() {
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.MainFragment newInstance(@org.jetbrains.annotations.NotNull
    com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
    com.project.schedule.ChangeLessonListener changeLessonListener) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/project/schedule/fragments/MainFragment$Companion;", "", "()V", "newInstance", "Lcom/project/schedule/fragments/MainFragment;", "lessonListener", "Lcom/project/schedule/LessonListener;", "changeLessonListener", "Lcom/project/schedule/ChangeLessonListener;", "Scheduler_1.0_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final com.project.schedule.fragments.MainFragment newInstance(@org.jetbrains.annotations.NotNull
        com.project.schedule.LessonListener lessonListener, @org.jetbrains.annotations.NotNull
        com.project.schedule.ChangeLessonListener changeLessonListener) {
            return null;
        }
    }
}