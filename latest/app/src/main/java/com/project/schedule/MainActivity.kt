package com.project.schedule

import android.os.Build.VERSION
import android.os.Bundle
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.project.schedule.fragments.ChangeLessonFragment
import com.project.schedule.fragments.MainFragment
import com.project.schedule.fragments.MessageFragment
import com.project.schedule.models.Lesson
import com.project.schedule.repository.LessonRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LessonListener, ChangeLessonListener {
    var coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var lessonRepository: LessonRepository

    private val TIME_INTERVAL = 3000

    private var mBackPressed =0L


    var baseUpdate = MutableLiveData<Boolean>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onResume() {
        super.onResume()

        if (VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT
            ) {

                setExit()



            }
        } else {
            onBackPressedDispatcher.addCallback(this /* lifecycle owner */, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    setExit()
                }
            })
        }
        setMainFragment()

        baseUpdate.observe(this,{
            updateDayFragment()
        })



    }

    private fun setExit(){
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            finishAffinity()
        } else {
            Toast.makeText(
                applicationContext,
                "Tap back button in order to exit",
                Toast.LENGTH_SHORT
            ).show()
        }
        mBackPressed = System.currentTimeMillis()
    }

    private fun updateDayFragment() {
        (supportFragmentManager.findFragmentByTag("Main") as MainFragment).updateDay()
        cancelTask()
    }

    private fun setMainFragment() {
       supportFragmentManager
           .beginTransaction()
           .add(R.id.main_container, MainFragment.newInstance(this, this),  "Main")
           .commit()
    }


    override fun editLesson(id: Long) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_container, ChangeLessonFragment.newInstance(id, this),  "Change")
            .commit()

    }

    override fun deleteLesson(id: Long) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_container, MessageFragment.newInstance(object: MessageCallback{
                override fun messageAccept() {
                   deleteLessonById(id)
                }

                override fun messageDecline() {
                    closeMessage()
                }

            }),  "Message")
            .commit()

    }

    private fun closeMessage() {
        supportFragmentManager.findFragmentByTag("Message")?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
    }


    fun deleteLessonById(id:Long){
        coroutineScope.launch {
            lessonRepository.deleteLessonById(id)
            baseUpdate.postValue(true)
            closeMessage()
        }
    }

    override fun setUpdateLesson(lesson: Lesson) {
        coroutineScope.launch {
            lessonRepository.updateLesson(lesson)
            baseUpdate.postValue(true)
        }
    }


    override fun createNewLesson(lesson: Lesson) {
        coroutineScope.launch {
            lessonRepository.insertNewLesson(lesson)
            baseUpdate.postValue(true)
        }

    }

    override fun cancelTask() {
        supportFragmentManager.findFragmentByTag("Change")?.let {
            supportFragmentManager
                .beginTransaction()
                .remove(it)
                .commit()
        }
    }
}