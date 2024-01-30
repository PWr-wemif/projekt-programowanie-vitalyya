package com.project.schedule.di

import com.project.schedule.utils.GsonUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GsonModule {
    @Provides
    fun provideGsonUtil(): GsonUtil {
        return GsonUtil()
    }
}