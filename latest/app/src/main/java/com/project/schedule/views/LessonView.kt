package com.project.schedule.views


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.project.schedule.LessonListener
import com.project.schedule.R
import com.project.schedule.models.Lesson

class LessonView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    val lessonListener: LessonListener,
    val lesson: Lesson
) :
    LinearLayout(context, attrs, defStyleAttr) {

    private val view: View = View.inflate(context, R.layout.lesson_view, this)


    lateinit var time: TextView
    lateinit var name: TextView
    lateinit var edit: ImageView
    lateinit var delete: ImageView

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        time = view.findViewById(R.id.time)
        name = view.findViewById(R.id.name)
        edit = view.findViewById(R.id.edit_lesson)
        delete = view.findViewById(R.id.delete_lesson)


        edit.setOnClickListener {
            lessonListener.editLesson(lesson.id)
        }

        delete.setOnClickListener {
            lessonListener.deleteLesson(lesson.id)
        }


        name.text = lesson.name

        val timeText = "${lesson.timeStartHours}:${
            if(lesson.timeStartMins<10){"0${lesson.timeStartMins}"}else{lesson.timeStartMins}}-${lesson.timeEndHours}: ${if(lesson.timeEndMin<10){"0${lesson.timeEndMin}"}else{lesson.timeEndMin}} " +
                "(${if(lesson.weekEven==1){"even"}else{"odd"}})"
        time.text= timeText

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    fun changeViewSize(newWidth: Int, newHeight: Int) {
        layoutParams.width = newWidth
        layoutParams.height = newHeight
        requestLayout()
    }


}