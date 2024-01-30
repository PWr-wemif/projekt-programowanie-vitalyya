package com.project.schedule.di

import com.project.schedule.utils.CalendarUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CalendarModule {

    @Provides
    fun provideCalendar(): CalendarUtil {
        return CalendarUtil()
    }
}