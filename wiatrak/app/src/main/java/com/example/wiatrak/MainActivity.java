package com.example.wiatrak;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.wiatrak.ui.theme.ClassSchedule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_LESSON_REQUEST = 1;
    private TableLayout scheduleTableLayout;
    private Button addLessonButton;
    private Button backButton, forwardButton;
    private TextView dateTextView;

    private boolean isEvenWeek = true;




    private ArrayList<ClassSchedule> evenWeekSchedule = new ArrayList<>();
    private ArrayList<ClassSchedule> oddWeekSchedule = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduleTableLayout = findViewById(R.id.scheduleTableLayout);
        addLessonButton = findViewById(R.id.addLessonButton);
        backButton = findViewById(R.id.backButton);
        forwardButton = findViewById(R.id.forwardButton);
        dateTextView = findViewById(R.id.dateTextView);

        // Set the current week
        setCurrentWeek();

        // Set up button listeners
        setupButtonListeners();

        // Load schedules from shared preferences
        loadSchedulesFromPreferences();

        // Display the current week's schedule
        displaySchedule();

        addLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddLessonActivity.class);
                startActivityForResult(intent, ADD_LESSON_REQUEST);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // -1 означає "попередній тиждень"
                changeWeek(-1);
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 означає "наступний тиждень"
                changeWeek(1);
            }
        });

        loadSchedulesFromPreferences();
        loadSchedules();
        displaySchedule();

    }



    private void loadSchedules() {
        // Load your schedules here...
        // For now, let's initialize them as new ArrayLists
        evenWeekSchedule = new ArrayList<>();
        oddWeekSchedule = new ArrayList<>();
    }

    private void saveScheduleToPreferences() {
        SharedPreferences prefs = getSharedPreferences("SchedulePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        String evenWeekJson = gson.toJson(evenWeekSchedule);
        String oddWeekJson = gson.toJson(oddWeekSchedule);

        Log.d("SaveData", "Saving Even Week: " + evenWeekJson);
        Log.d("SaveData", "Saving Odd Week: " + oddWeekJson);

        editor.putString("evenWeekSchedule", evenWeekJson);
        editor.putString("oddWeekSchedule", oddWeekJson);
        editor.apply();
    }

    // Викликайте цей метод у onCreate або відповідно до потреби
    private void loadSchedulesFromPreferences() {
        SharedPreferences prefs = getSharedPreferences("SchedulePrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String evenWeekJson = prefs.getString("evenWeekSchedule", null);
        String oddWeekJson = prefs.getString("oddWeekSchedule", null);

        Log.d("LoadData", "Loaded Even Week: " + evenWeekJson);
        Log.d("LoadData", "Loaded Odd Week: " + oddWeekJson);

        Type type = new TypeToken<ArrayList<ClassSchedule>>(){}.getType();

        evenWeekSchedule = gson.fromJson(evenWeekJson, type);
        oddWeekSchedule = gson.fromJson(oddWeekJson, type);

        // Тепер ми ініціалізуємо списки тільки якщо вони null
        if (evenWeekSchedule == null) {
            evenWeekSchedule = new ArrayList<>();
        }
        if (oddWeekSchedule == null) {
            oddWeekSchedule = new ArrayList<>();
        }
    }




    @SuppressLint("SimpleDateFormat")
    private void setCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String startDate = sdf.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 4);
        String endDate = sdf.format(calendar.getTime());

        dateTextView.setText(startDate + " - " + endDate);
    }

    private ArrayList<ClassSchedule> getCombinedSchedule() {
        ArrayList<ClassSchedule> combinedSchedule = new ArrayList<>();
        combinedSchedule.addAll(evenWeekSchedule);
        combinedSchedule.addAll(oddWeekSchedule);
        return combinedSchedule;
    }


    private void changeWeek(int weeks) {
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date startDate = sdf.parse(dateTextView.getText().toString().split(" - ")[0]);
            if (startDate != null) {
                calendar.setTime(startDate);
                calendar.add(Calendar.WEEK_OF_YEAR, weeks);
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                String newStartDate = sdf.format(calendar.getTime());

                calendar.add(Calendar.DAY_OF_MONTH, 4);
                String newEndDate = sdf.format(calendar.getTime());

                dateTextView.setText(newStartDate + " - " + newEndDate);

                // Оновлення змінної, яка відслідковує, чи поточний тиждень парний
                isEvenWeek = !isEvenWeek;

                displaySchedule(); // Refresh schedule when week changes
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //тут карочє висвітлює план якщо щось тут мінять то не буде розклад гортатись


    String[] pairsTime = {
            "7:30 - 9:00",
            "9:15 - 11:00",
            "11:15 - 13:00",
            "13:15 - 15:00",
            "15:15 - 17:00",
            "17:05 - 18:45",
            "18:55 - 20:35"
    };
    private void displaySchedule() {
        scheduleTableLayout.removeAllViews();

        boolean isCurrentWeekEven = isCurrentWeekEven();
        List<ClassSchedule> currentWeekSchedule = isEvenWeek ? evenWeekSchedule : oddWeekSchedule;

        Log.d("MainActivity", "Displaying schedule for " + (isCurrentWeekEven ? "even" : "odd") + " week. Number of lessons: " + currentWeekSchedule.size());

        String[] daysOfWeek = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek"};
        int[] hours = new int[16];
        for (int i = 0; i < 16; i++) {
            hours[i] = 7 + i;
        }

        TableRow headerRow = new TableRow(this);
        headerRow.addView(createTextView("", true));
        for (String day : daysOfWeek) {
            headerRow.addView(createTextView(day, true));
        }
        scheduleTableLayout .addView(headerRow);

        for (int i = 0; i < pairsTime.length; i++) {
            TableRow row = new TableRow(this);
            row.addView(createTextView(pairsTime[i], false)); // Додаємо час пари

            for (String day : daysOfWeek) {
                String subject = "";
                for (ClassSchedule schedule : currentWeekSchedule) {
                    // Порівняння за часовим слотом замість цілого числа
                    if (schedule.getDayOfWeek().equals(day) && schedule.getHour().equals(pairsTime[i])) {
                        subject = schedule.getSubject();
                        break;
                    }
                }
                row.addView(createTextView(subject, false));
            }
            scheduleTableLayout.addView(row);
        }
    }
    private boolean isCurrentWeekEven() {
        Calendar calendar = Calendar.getInstance();
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        boolean isEven = weekOfYear % 2 == 0;
        Log.d("MainActivity", "Week of year: " + weekOfYear + " is " + (isEven ? "even" : "odd"));
        return isEven;
    }

    private TextView createTextView(String text, boolean isHeader) {
        TextView textView = new TextView(this);
        textView.setText(text);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 10, 0, 10);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(5, 20, 5, 20);

        if (!isHeader) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.cell_border));
        } else {
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.rowBackgroundColor));
            textView.setTextColor(ContextCompat.getColor(this, R.color.textColor));
        }

        return textView;
    }





    private void setupButtonListeners() {
        addLessonButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddLessonActivity.class);
            startActivityForResult(intent, ADD_LESSON_REQUEST);
        });

        backButton.setOnClickListener(v -> changeWeek(-1));
        forwardButton.setOnClickListener(v -> changeWeek(1));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_LESSON_REQUEST && resultCode == RESULT_OK && data != null) {
            String subject = data.getStringExtra("subject");
            String timeSlot = data.getStringExtra("timeSlot");
            boolean evenWeek = data.getBooleanExtra("evenWeek", false);
            String[] selectedDays = data.getStringArrayExtra("daysOfWeek");

            if (selectedDays != null) {
                for (String day : selectedDays) {
                    if (day != null && timeSlot != null) {
                        ClassSchedule newLesson = new ClassSchedule(day, timeSlot, subject, evenWeek);
                        if (evenWeek) {
                            evenWeekSchedule.add(newLesson);
                        } else {
                            oddWeekSchedule.add(newLesson);
                        }
                        Log.d("AddLessonActivity", "Adding new lesson: " + newLesson.toString());
                    }
                }
            }

            saveScheduleToPreferences();
            displaySchedule();
        }
    }

    private int convertTimeSlotToHour(String timeSlot) {
        // Припустимо, timeSlot має формат "7:30 - 9:00"
        // Виберемо першу частину до дефіса
        String startTime = timeSlot.split(" - ")[0]; // "7:30"
        // Виберемо годину
        return Integer.parseInt(startTime.split(":")[0]); // "7"
    }



    @Override
    protected void onResume() {
        super.onResume();
        loadSchedulesFromPreferences(); // Перезавантажуємо розклад при поверненні до Activity
        displaySchedule();
    }

}