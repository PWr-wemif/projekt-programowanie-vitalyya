package com.project.schedule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import com.project.schedule.ChangeLessonListener
import com.project.schedule.R
import com.project.schedule.db.AppDb
import com.project.schedule.models.Lesson
import com.project.schedule.models.LessonOnUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val PARAM_ID = "id"

@AndroidEntryPoint
class ChangeLessonFragment : Fragment() {


    @Inject
    lateinit var db: AppDb

    private var id: Long = 0


    private var coroutineScope = CoroutineScope(Dispatchers.IO)


    lateinit var editHead: TextView
    lateinit var evenWeekInput: Spinner
    lateinit var dayOfWeekInput: Spinner
    lateinit var startHoursInput: EditText
    lateinit var startMinsInput: EditText
    lateinit var endHoursInput: EditText
    lateinit var endMinsInput: EditText
    lateinit var lessonNameInput: EditText
    lateinit var errorMsg: TextView
    lateinit var editBt: Button
    lateinit var cancelBt: Button

    private var lessonML: MutableLiveData<Lesson> = MutableLiveData()


    lateinit var changeLessonListener: ChangeLessonListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getLong(PARAM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_change_lesson, container, false)

        initUi(view)
        return view
    }

    private fun initUi(view: View) {
        editHead = view.findViewById(R.id.head_change)
        dayOfWeekInput = view.findViewById(R.id.day_week_input)
        evenWeekInput = view.findViewById(R.id.even_week_input)
        startHoursInput = view.findViewById(R.id.start_hours_input)
        startMinsInput = view.findViewById(R.id.start_mins_input)
        endHoursInput = view.findViewById(R.id.end_hours_input)
        endMinsInput = view.findViewById(R.id.end_mins_input)
        lessonNameInput = view.findViewById(R.id.lesson_name_input)
        errorMsg = view.findViewById(R.id.error_msg_create)
        editBt = view.findViewById(R.id.edit_button)
        cancelBt = view.findViewById(R.id.cancel_button)

        if (id == 0L) {
            editBt.text = resources.getString(R.string.create)
            editHead.text = resources.getString(R.string.create)
        } else {
            editHead.text = resources.getString(R.string.edit)
            editBt.text = resources.getString(R.string.edit)
        }

        val daysAdapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.days,
            R.layout.custom_spinner
        )


        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        dayOfWeekInput.adapter = daysAdapter

        dayOfWeekInput.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val weeksAdapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(), R.array.weeks,
            R.layout.custom_spinner
        )


        weeksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        evenWeekInput.adapter = weeksAdapter

        evenWeekInput.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        editBt.setOnClickListener {
            val dayOfWeek = dayOfWeekInput.selectedItemPosition + 1
            val evenWeek = evenWeekInput.selectedItemPosition
            val startHours = if (startHoursInput.text.toString() != "") {
                startHoursInput.text.toString().toInt()
            } else {
                0
            }
            val startMins = if (startMinsInput.text.toString() != "") {
                startMinsInput.text.toString().toInt()
            } else {
                0
            }
            val endHours = if (endHoursInput.text.toString() != "") {
                endHoursInput.text.toString().toInt()
            } else {
                0
            }
            val endMins = if (endMinsInput.text.toString() != "") {
                endMinsInput.text.toString().toInt()
            } else {
                0
            }
            val name = lessonNameInput.text.toString()

            if (
                (dayOfWeek !in 1..5) ||
                (evenWeek !in 0..1) ||
                (startHours !in 8..20) ||
                (startMins !in 0..59) ||
                (endHours !in 8..20) ||
                (endMins !in 0..59) ||
                name == ""
                ||(startHours*60+startMins>=endHours*60+endMins)
            ) {
                errorMsg.text = resources.getString(R.string.errorMsgEdit)
            } else {
                errorMsg.text = ""
                var lesson = Lesson(
                    id = id,
                    dayOfWeek = dayOfWeek,
                    weekEven = evenWeek,
                    timeStartHours = startHours,
                    timeStartMins = startMins,
                    timeEndHours = endHours,
                    timeEndMin = endMins,
                    name = name
                )
                if (id == 0L) {
                    changeLessonListener.createNewLesson(lesson)
                } else {
                    changeLessonListener.setUpdateLesson(lesson)
                }
            }
        }


        cancelBt.setOnClickListener {
            changeLessonListener.cancelTask()
        }



        if (id != 0L) {
            coroutineScope.launch {
                var lesson = db.getLessonDao().getLessonById(id)
                var lessonBase = Lesson(
                    id = lesson.id,
                    dayOfWeek = lesson.dayOfWeek - 1,
                    weekEven = lesson.weekEven,
                    timeStartHours = lesson.timeStartHours,
                    timeStartMins = lesson.timeStartMins,
                    timeEndHours = lesson.timeEndHours,
                    timeEndMin = lesson.timeEndMin,
                    name = lesson.name
                )

                lessonML.postValue(
                    lessonBase
                )

            }
        } else {
            dayOfWeekInput.setSelection(0)
            evenWeekInput.setSelection(1)
            startHoursInput.setText("08")
            startMinsInput.setText("00")
            endHoursInput.setText("08")
            endMinsInput.setText("00")
        }


        lessonML.observe(viewLifecycleOwner,{
            setLessonFromBaseToUi(it)
        })


    }

    private fun setLessonFromBaseToUi(it: Lesson) {
        dayOfWeekInput.setSelection(it.dayOfWeek - 1)
        evenWeekInput.setSelection(it.weekEven)

        startHoursInput.setText(
            if (it.timeStartHours in 0..9) {
                "0${it.timeStartHours}"
            } else {
                "${it.timeStartHours}"
            }
        )
        startMinsInput.setText(
            if (it.timeStartMins in 0..9) {
                "0${it.timeStartMins}"
            } else {
                "${it.timeStartMins}"
            }
        )
        endHoursInput.setText(
            if (it.timeEndHours in 0..9) {
                "0${it.timeEndHours}"
            } else {
                "${it.timeEndHours}"
            }
        )
        endMinsInput.setText(
            if (it.timeEndMin in 0..9) {
                "0${it.timeEndMin}"
            } else {
                "${it.timeEndMin}"
            }
        )
        lessonNameInput.setText(it.name)

    }

    companion object {
        @JvmStatic
        fun newInstance(id: Long, changeLessonListener: ChangeLessonListener) =
            ChangeLessonFragment().apply {
                arguments = Bundle().apply {
                    putLong(PARAM_ID, id)
                }
                this.changeLessonListener = changeLessonListener
            }
    }
}