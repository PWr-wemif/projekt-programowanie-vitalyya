package com.example.wiatrak.ui.theme;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.wiatrak.R;

import java.util.ArrayList;

public class LessonAdapter extends ArrayAdapter<ClassSchedule> {

    private ScheduleUpdateListener updateListener;

    public interface ScheduleUpdateListener {
        void onScheduleUpdated(ClassSchedule lessonToDelete);
    }

    public LessonAdapter(Context context, ArrayList<ClassSchedule> lessons, ScheduleUpdateListener updateListener) {
        super(context, 0, lessons);
        this.updateListener = updateListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClassSchedule lesson = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lesson_item, parent, false);
        }

        TextView lessonTextView = convertView.findViewById(R.id.lessonTextView);
        Button editButton = convertView.findViewById(R.id.editButton);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        lessonTextView.setText(lesson.getSubject() + " - " + lesson.getHour());


        editButton.setOnClickListener(v -> {
            // Логіка для редагування уроку
        });

        deleteButton.setOnClickListener(v -> {
            ClassSchedule lessonToDelete = getItem(position);
            remove(lessonToDelete);
            notifyDataSetChanged();

            if (updateListener != null) {
                updateListener.onScheduleUpdated(lessonToDelete);
            }
        });

        return convertView;
    }



    private void updateScheduleInStorage(ClassSchedule lessonToDelete) {
        if (updateListener != null) {
            updateListener.onScheduleUpdated(lessonToDelete);
        }
    }

}

