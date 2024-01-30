package com.project.schedule.fragments

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.project.schedule.ChangeLessonListener
import com.project.schedule.LessonListener
import com.project.schedule.MainActivity
import com.project.schedule.R
import com.project.schedule.TabListener
import com.project.schedule.db.AppDb
import com.project.schedule.models.Lesson
import com.project.schedule.models.WeekInfo
import com.project.schedule.repository.LessonRepository
import com.project.schedule.utils.CalendarUtil
import com.project.schedule.utils.GsonUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 *
 */

@AndroidEntryPoint
class MainFragment(
    val lessonListener: LessonListener,
    val changeLessonListener: ChangeLessonListener
) : Fragment(), TabListener {

    companion object {
        @JvmStatic
        fun newInstance(
            lessonListener: LessonListener,
            changeLessonListener: ChangeLessonListener
        ) =
            MainFragment(lessonListener, changeLessonListener)
    }

    lateinit var previousBt: ImageView
    lateinit var previousTv: TextView
    lateinit var weekTv: TextView
    lateinit var nextBt: ImageView
    lateinit var nextTv: TextView
    lateinit var textViewMonday: TextView
    lateinit var textViewTuesday: TextView
    lateinit var textViewWednesday: TextView
    lateinit var textViewThursday: TextView
    lateinit var textViewFriday: TextView


    @Inject
    lateinit var calendarUtil: CalendarUtil

    @Inject
    lateinit var lessonRepository: LessonRepository

    @Inject
    lateinit var firebaseRemoteConfig: FirebaseRemoteConfig

    @Inject
    lateinit var db: AppDb

    @Inject
    lateinit var gsonUtil: GsonUtil

    var userTab = 1

    private lateinit var listButtons: Array<TextView>


    var list: MutableLiveData<List<Lesson>> = MutableLiveData()


    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    lateinit var weekInfo: WeekInfo

    lateinit var addButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        setUI(view)
        return view
    }


    private fun setUI(view: View) {
        previousBt = view.findViewById(R.id.previous_bt)
        previousTv = view.findViewById(R.id.previous_label)
        weekTv = view.findViewById(R.id.week_tv)
        nextTv = view.findViewById(R.id.next_label)
        nextBt = view.findViewById(R.id.next_bt)
        textViewMonday = view.findViewById(R.id.tab_monday)
        textViewTuesday = view.findViewById(R.id.tab_tuesday)
        textViewWednesday = view.findViewById(R.id.tab_wednesday)
        textViewThursday = view.findViewById(R.id.tab_thursday)
        textViewFriday = view.findViewById(R.id.tab_friday)

        addButton = view.findViewById(R.id.add_lesson)

        listButtons = arrayOf(
            textViewMonday,
            textViewTuesday,
            textViewWednesday,
            textViewThursday,
            textViewFriday
        )


        previousTv.setOnClickListener {
            changeWeek(false)
        }

        previousBt.setOnClickListener {
            changeWeek(false)
        }

        nextBt.setOnClickListener {
            changeWeek(true)
        }

        nextBt.setOnClickListener {
            changeWeek(true)
        }

        for (i in listButtons.indices) {
            listButtons[i].setOnClickListener {
                listButtons.forEach {
                    it.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.tab_deactive, null)
                }
                listButtons[i].background =
                    ResourcesCompat.getDrawable(resources, R.drawable.tab_active, null)

                pressTab(i + 1)
            }
        }

        addButton.setOnClickListener {
            lessonListener.editLesson(0)
        }

    }

    private fun changeWeek(next: Boolean) {
        calendarUtil.changeWeek(next)
        weekInfo = calendarUtil.getWeekInfo()
        setWeek()
        pressTab(getIndexForTab())
    }

    override fun onResume() {
        super.onResume()

        weekInfo = calendarUtil.getWeekInfo()

        setWeek();


        childFragmentManager.beginTransaction()
            .add(
                R.id.day_container,
                DayFragment.newInstance(lessonListener, changeLessonListener),
                "Day"
            )
            .commit()

       val indexForTab = getIndexForTab()
        pressTab(indexForTab)

        list.observe(viewLifecycleOwner) {
            (childFragmentManager.fragments.get(0) as DayFragment).setList(it)
        }

    }

    private fun getIndexForTab(): Int {
        val todayIndex = calendarUtil.getTodayIndex()
        if (todayIndex in 1..5) {
            listButtons[todayIndex - 1].performClick()
            return todayIndex
        } else {
            listButtons[0].performClick()
           return 1
        }

    }


    private fun setWeek() {
        weekTv.text = "${weekInfo.weekString} (${calendarUtil.getWeekInfo().evenString})"
    }

    override fun pressTab(indexTab: Int) {

        userTab = indexTab

        coroutineScope.launch {
            list.postValue(lessonRepository.getLessonByDayAndWeek(indexTab, weekInfo.even))
        }

    }

    fun updateDay() {
        pressTab(userTab)
    }


}