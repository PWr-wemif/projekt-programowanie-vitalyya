package com.project.schedule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.project.schedule.ChangeLessonListener
import com.project.schedule.utils.HourIdentifier
import com.project.schedule.LessonListener
import com.project.schedule.R
import com.project.schedule.models.Hour
import com.project.schedule.models.Lesson
import com.project.schedule.models.LessonOnUI
import com.project.schedule.utils.GsonUtil
import com.project.schedule.utils.TimeToViewUtil
import com.project.schedule.views.LessonView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [DayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class DayFragment : Fragment() {

    lateinit var lessonListener: LessonListener
    lateinit var changeLessonListener: ChangeLessonListener


    lateinit var listLessons: List<Lesson>

    @Inject
    lateinit var gsonUtil: GsonUtil


    private var listAddedLessons: ArrayList<LessonOnUI> = ArrayList()


    lateinit var mainLayout: ConstraintLayout
    lateinit var listTv: ArrayList<Hour>

    private val timeToViewUtil = TimeToViewUtil()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_day2, container, false)
        setUI(view)
        return view
    }


    private fun setUI(view: View) {

        mainLayout = view.findViewById(R.id.main_layout)

        listTv = HourIdentifier(view).makeHours(
            arrayOf(
                R.id.hour_8,
                R.id.hour_8_015,
                R.id.hour_8_1530,
                R.id.hour_8_3045,
                R.id.hour_8_4560,
                R.id.hour_9,
                R.id.hour_9_015,
                R.id.hour_9_1530,
                R.id.hour_9_3045,
                R.id.hour_9_4560,
                R.id.hour_10,
                R.id.hour_10_015,
                R.id.hour_10_1530,
                R.id.hour_10_3045,
                R.id.hour_10_4560,
                R.id.hour_11,
                R.id.hour_11_015,
                R.id.hour_11_1530,
                R.id.hour_11_3045,
                R.id.hour_11_4560,
                R.id.hour_12,
                R.id.hour_12_015,
                R.id.hour_12_1530,
                R.id.hour_12_3045,
                R.id.hour_12_4560,
                R.id.hour_13,
                R.id.hour_13_015,
                R.id.hour_13_1530,
                R.id.hour_13_3045,
                R.id.hour_13_4560,
                R.id.hour_14,
                R.id.hour_14_015,
                R.id.hour_14_1530,
                R.id.hour_14_3045,
                R.id.hour_14_4560,
                R.id.hour_15,
                R.id.hour_15_015,
                R.id.hour_15_1530,
                R.id.hour_15_3045,
                R.id.hour_15_4560,
                R.id.hour_16,
                R.id.hour_16_015,
                R.id.hour_16_1530,
                R.id.hour_16_3045,
                R.id.hour_16_4560,
                R.id.hour_17,
                R.id.hour_17_015,
                R.id.hour_17_1530,
                R.id.hour_17_3045,
                R.id.hour_17_4560,
                R.id.hour_18,
                R.id.hour_18_015,
                R.id.hour_18_1530,
                R.id.hour_18_3045,
                R.id.hour_18_4560,
                R.id.hour_19,
                R.id.hour_19_015,
                R.id.hour_19_1530,
                R.id.hour_19_3045,
                R.id.hour_19_4560,
                R.id.hour_20,
                R.id.hour_20_015,
                R.id.hour_20_1530,
                R.id.hour_20_3045,
                R.id.hour_20_4560
            )
        )


        var vto = mainLayout.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                mainLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                //workUI()

            }
        })


    }

    companion object {
        @JvmStatic
        fun newInstance(lessonListener: LessonListener, changeLessonListener: ChangeLessonListener) =
            DayFragment().apply {
                this.lessonListener = lessonListener
                this.changeLessonListener = changeLessonListener
            }

    }


    fun setList(list: List<Lesson>) {
        listLessons = list
        workUI()
    }

    fun workUI() {
        val lessonWidth = listTv[8].mins?.get(2)?.width!! /12

        listAddedLessons.forEach {
            mainLayout.removeView(mainLayout.findViewById(it.lessonUIID))
        }

        listAddedLessons.clear()

        listLessons.forEach {
            var lesson: LessonView =
                LessonView(context = requireContext(), lessonListener = lessonListener, lesson = it)
            lesson.id = View.generateViewId()

            val timeToViewModel = timeToViewUtil.convertInfo(
                it.timeStartHours,
                it.timeStartMins,
                it.timeEndHours,
                it.timeEndMin
            )




            //Placing
            var startX =
                listTv[timeToViewModel.indexHoursStart].mins?.get(timeToViewModel.indexMinutesStart)?.x!!
            val startY =
                listTv[timeToViewModel.indexHoursStart].mins?.get(timeToViewModel.indexMinutesStart)?.y!!
            val endY =
                listTv[timeToViewModel.indexHoursEnd].mins?.get(timeToViewModel.indexMinutesEnd)?.y!!
            val lessonHeight: Int = (endY - startY).toInt() -5

            var moveX = lessonWidth + 20

             while(!checkForFreeSpace(startX, startY,endY, lessonHeight, lessonWidth)){
                 startX += moveX
             }



            lesson.x = startX
            lesson.y = startY

            mainLayout.addView(lesson)
            lesson.layoutParams = ViewGroup.LayoutParams(lessonWidth, lessonHeight)

            val lessonOnUI = LessonOnUI(
                lessonUIID = lesson.id,
                lessonTopStartX = startX,
                lessonTopStartY = startY,
                lessonTopEndX = startX + lessonWidth,
                lessonTopEndY = startY,
                lessonBottomStartX = startX,
                lessonBottomStartY = startY + lessonHeight,
                lessonBottomEndX = startX + lessonWidth,
                lessonBottomEndY = startY + lessonHeight,
                lessonWidh = lessonWidth,
                lessonHeight = lessonHeight
            )
            listAddedLessons.add(lessonOnUI)
        }


    }

    private fun checkForFreeSpace(startX: Float, startY: Float, endY:Float, lessonHeight: Int, lessonWidth: Int):Boolean {
        listAddedLessons.forEach{
            if((startY in it.lessonTopStartY..it.lessonBottomStartY && startX in it.lessonTopStartX..it.lessonTopEndX)||
                (endY in it.lessonTopStartY..it.lessonBottomStartY && startX in it.lessonTopStartX..it.lessonTopEndX)){

                return false
            }
        }
        return true
    }


}