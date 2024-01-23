package com.example.wiatrak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.wiatrak.ui.theme.ClassSchedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AddLessonActivity : AppCompatActivity() {
    private lateinit var subjectNameEditText: EditText
    private lateinit var spinnerTimeSelection: Spinner
    private lateinit var checkBoxMonday: CheckBox
    private lateinit var checkBoxTuesday: CheckBox
    private lateinit var checkBoxWednesday: CheckBox
    private lateinit var checkBoxThursday: CheckBox
    private lateinit var checkBoxFriday: CheckBox
    private lateinit var checkBoxEvenWeek: CheckBox
    private lateinit var checkBoxOddWeek: CheckBox
    private lateinit var saveButton: Button

    private lateinit var listViewSubjects: ListView
    private var listOfSubjects = arrayListOf<String>()

    private val daysOfWeek = mutableListOf<String>()

    //до
    private val combinedSchedule: ArrayList<ClassSchedule>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_lesson)

        // Ініціалізація компонентів
        subjectNameEditText = findViewById(R.id.subjectNameEditText)
        spinnerTimeSelection = findViewById(R.id.spinner_time_selection)
        checkBoxMonday = findViewById(R.id.checkbox_monday)
        checkBoxTuesday = findViewById(R.id.checkbox_tuesday)
        checkBoxWednesday = findViewById(R.id.checkbox_wednesday)
        checkBoxThursday = findViewById(R.id.checkbox_thursday)
        checkBoxFriday = findViewById(R.id.checkbox_friday)
        checkBoxEvenWeek = findViewById(R.id.checkbox_parzysty)
        checkBoxOddWeek = findViewById(R.id.checkbox_nieparzysty)
        saveButton = findViewById(R.id.button_save_changes)

        listViewSubjects = findViewById(R.id.listViewSubjects)
        loadSubjects()
        setupListView()



        // ...
        // Налаштування Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.pairs_time_array, // оновлений масив
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerTimeSelection.adapter = adapter
        }

        // Обробник натискання на кнопку "Save"
        saveButton.setOnClickListener {
            saveLesson()
        }




    }

    private fun loadSubjects() {
        val sharedPrefs = getSharedPreferences("YourPrefsName", Context.MODE_PRIVATE)
        val subjectsJson = sharedPrefs.getString("subjectsKey", null)

        if (subjectsJson != null) {
            val type = object : TypeToken<ArrayList<String>>() {}.type
            listOfSubjects = Gson().fromJson(subjectsJson, type)
        } else {
            // Якщо немає збережених предметів, ініціалізуйте пустим списком або списком за замовчуванням.
            listOfSubjects = arrayListOf() // або використовуйте ваш базовий список
        }
        Log.d("AddLessonActivity", "Loaded subjects: ${listOfSubjects.joinToString(", ")}")

        setupListView()
    }

    private fun setupListView() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfSubjects)
        listViewSubjects.adapter = adapter
    }

    private fun convertTimeSlotToHour(timeSlot: String): Int {
        // Припустимо, timeSlot має формат "7:30 - 9:00"
        // Виберемо першу частину до дефіса
        val startTime =
            timeSlot.split(" - ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()[0] // "7:30"
        // Виберемо годину
        return startTime.split(":".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()[0].toInt() // "7"
    }




    private fun saveLesson() {
        // Збираємо дані з UI
        val subject = subjectNameEditText.text.toString()
        val timeSlot = spinnerTimeSelection.selectedItem.toString() // Використовуємо timeSlot напряму
        val evenWeek = checkBoxEvenWeek.isChecked
        val oddWeek = checkBoxOddWeek.isChecked

        Log.d("AddLessonActivity", "Saving lesson: Subject=$subject, TimeSlot=$timeSlot, EvenWeek=$evenWeek, OddWeek=$oddWeek")

        // Створення Intent для передачі даних назад у MainActivity
        val intent = Intent().apply {
            putExtra("subject", subject)
            putExtra("timeSlot", timeSlot) // Тепер передаємо timeSlot як рядок
            putExtra("evenWeek", evenWeek)
            putExtra("oddWeek", oddWeek)
        }

        // Збираємо вибрані дні тижня
        val daysOfWeek = mutableListOf<String>().apply {
            if (checkBoxMonday.isChecked) add("Poniedziałek")
            if (checkBoxTuesday.isChecked) add("Wtorek")
            if (checkBoxWednesday.isChecked) add("Środa")
            if (checkBoxThursday.isChecked) add("Czwartek")
            if (checkBoxFriday.isChecked) add("Piątek")
        }

        Log.d("AddLessonActivity", "Days of Week for lesson: " + daysOfWeek.joinToString(", "))

        // Додаємо вибрані дні до Intent
        intent.putExtra("daysOfWeek", daysOfWeek.toTypedArray())

        // Встановлення результату та завершення активності
        setResult(RESULT_OK, intent)
        finish()
    }
}