package com.project.schedule.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.project.schedule.MessageCallback;
import com.project.schedule.R;

/**
 * A simple [Fragment] subclass.
 * Use the [MessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/project/schedule/fragments/MessageFragment;", "Landroidx/fragment/app/Fragment;", "()V", "buttonAccept", "Landroid/widget/Button;", "getButtonAccept", "()Landroid/widget/Button;", "setButtonAccept", "(Landroid/widget/Button;)V", "buttonDecline", "getButtonDecline", "setButtonDecline", "messageCallback", "Lcom/project/schedule/MessageCallback;", "getMessageCallback", "()Lcom/project/schedule/MessageCallback;", "setMessageCallback", "(Lcom/project/schedule/MessageCallback;)V", "initUI", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "Scheduler_1.0_debug"})
public final class MessageFragment extends androidx.fragment.app.Fragment {
    public com.project.schedule.MessageCallback messageCallback;
    public android.widget.Button buttonAccept;
    public android.widget.Button buttonDecline;
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.MessageFragment.Companion Companion = null;
    
    public MessageFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.schedule.MessageCallback getMessageCallback() {
        return null;
    }
    
    public final void setMessageCallback(@org.jetbrains.annotations.NotNull
    com.project.schedule.MessageCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getButtonAccept() {
        return null;
    }
    
    public final void setButtonAccept(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getButtonDecline() {
        return null;
    }
    
    public final void setButtonDecline(@org.jetbrains.annotations.NotNull
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
    
    private final void initUI(android.view.View view) {
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final com.project.schedule.fragments.MessageFragment newInstance(@org.jetbrains.annotations.NotNull
    com.project.schedule.MessageCallback messageCallback) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/project/schedule/fragments/MessageFragment$Companion;", "", "()V", "newInstance", "Lcom/project/schedule/fragments/MessageFragment;", "messageCallback", "Lcom/project/schedule/MessageCallback;", "Scheduler_1.0_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final com.project.schedule.fragments.MessageFragment newInstance(@org.jetbrains.annotations.NotNull
        com.project.schedule.MessageCallback messageCallback) {
            return null;
        }
    }
}