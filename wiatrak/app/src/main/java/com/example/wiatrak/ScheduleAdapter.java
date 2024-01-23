package com.example.wiatrak;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wiatrak.ui.theme.ClassSchedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<ClassSchedule> scheduleList;
    private List<ClassSchedule> allScheduleList;

    public ScheduleAdapter(List<ClassSchedule> allScheduleList) {
        this.allScheduleList = new ArrayList<>(allScheduleList);
        updateScheduleListBasedOnWeek();
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        ClassSchedule scheduleItem = scheduleList.get(position);
        holder.dayOfWeekTextView.setText(scheduleItem.getDayOfWeek());
        holder.hourTextView.setText(scheduleItem.getHour());
        holder.subjectTextView.setText(scheduleItem.getSubject());
    }

    @Override
    public int getItemCount() {
        return (scheduleList != null) ? scheduleList.size() : 0;
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        public TextView dayOfWeekTextView;
        public TextView hourTextView;
        public TextView subjectTextView;

        public ScheduleViewHolder(View view) {
            super(view);
            dayOfWeekTextView = view.findViewById(R.id.dayOfWeek);
            hourTextView = view.findViewById(R.id.hour);
            subjectTextView = view.findViewById(R.id.subject);
        }
    }

    // Оновлення загального списку уроків та відфільтрованого списку відповідно до типу тижня
    public void updateScheduleList(List<ClassSchedule> newAllScheduleList) {
        allScheduleList = newAllScheduleList;
        scheduleList.clear();
        Calendar calendar = Calendar.getInstance();
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        boolean isCurrentWeekEven = weekOfYear % 2 == 0;

        if (allScheduleList != null) {
            for (ClassSchedule schedule : allScheduleList) {
                if (schedule.isEvenWeek() == isCurrentWeekEven) {
                    scheduleList.add(schedule);
                }
            }
        }
        notifyDataSetChanged();
        Log.d("ScheduleAdapter", "Updated schedule list. New list size: " + scheduleList.size());
    }

    // Відфільтровування уроків відповідно до поточного тижня
    private void updateScheduleListBasedOnWeek() {
        scheduleList = new ArrayList<>(); // Ініціалізація відфільтрованого списку
        Calendar calendar = Calendar.getInstance();
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        boolean isCurrentWeekEven = weekOfYear % 2 == 0;

        for (ClassSchedule schedule : allScheduleList) {
            if (schedule.isEvenWeek() == isCurrentWeekEven) {
                scheduleList.add(schedule);
            }
        }
        notifyDataSetChanged(); // Оповіщення адаптера про зміни
    }
}
