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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"PARAM_ID", "", "Scheduler_1.0_debug"})
public final class ChangeLessonFragmentKt {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PARAM_ID = "id";
}