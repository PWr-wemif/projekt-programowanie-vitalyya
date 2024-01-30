package com.project.schedule.di

import com.project.schedule.db.AppDb
import com.project.schedule.db.LessonDao
import com.project.schedule.repository.LessonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object  DbModule {

    @Provides
    fun provideRepository(appDb: AppDb): LessonRepository{
        return LessonRepository(appDb)
    }


}