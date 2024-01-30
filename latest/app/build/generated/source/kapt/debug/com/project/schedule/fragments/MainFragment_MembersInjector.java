package com.project.schedule.fragments;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.project.schedule.db.AppDb;
import com.project.schedule.repository.LessonRepository;
import com.project.schedule.utils.CalendarUtil;
import com.project.schedule.utils.GsonUtil;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
  private final Provider<CalendarUtil> calendarUtilProvider;

  private final Provider<LessonRepository> lessonRepositoryProvider;

  private final Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider;

  private final Provider<AppDb> dbProvider;

  private final Provider<GsonUtil> gsonUtilProvider;

  public MainFragment_MembersInjector(Provider<CalendarUtil> calendarUtilProvider,
      Provider<LessonRepository> lessonRepositoryProvider,
      Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider, Provider<AppDb> dbProvider,
      Provider<GsonUtil> gsonUtilProvider) {
    this.calendarUtilProvider = calendarUtilProvider;
    this.lessonRepositoryProvider = lessonRepositoryProvider;
    this.firebaseRemoteConfigProvider = firebaseRemoteConfigProvider;
    this.dbProvider = dbProvider;
    this.gsonUtilProvider = gsonUtilProvider;
  }

  public static MembersInjector<MainFragment> create(Provider<CalendarUtil> calendarUtilProvider,
      Provider<LessonRepository> lessonRepositoryProvider,
      Provider<FirebaseRemoteConfig> firebaseRemoteConfigProvider, Provider<AppDb> dbProvider,
      Provider<GsonUtil> gsonUtilProvider) {
    return new MainFragment_MembersInjector(calendarUtilProvider, lessonRepositoryProvider, firebaseRemoteConfigProvider, dbProvider, gsonUtilProvider);
  }

  @Override
  public void injectMembers(MainFragment instance) {
    injectCalendarUtil(instance, calendarUtilProvider.get());
    injectLessonRepository(instance, lessonRepositoryProvider.get());
    injectFirebaseRemoteConfig(instance, firebaseRemoteConfigProvider.get());
    injectDb(instance, dbProvider.get());
    injectGsonUtil(instance, gsonUtilProvider.get());
  }

  @InjectedFieldSignature("com.project.schedule.fragments.MainFragment.calendarUtil")
  public static void injectCalendarUtil(MainFragment instance, CalendarUtil calendarUtil) {
    instance.calendarUtil = calendarUtil;
  }

  @InjectedFieldSignature("com.project.schedule.fragments.MainFragment.lessonRepository")
  public static void injectLessonRepository(MainFragment instance,
      LessonRepository lessonRepository) {
    instance.lessonRepository = lessonRepository;
  }

  @InjectedFieldSignature("com.project.schedule.fragments.MainFragment.firebaseRemoteConfig")
  public static void injectFirebaseRemoteConfig(MainFragment instance,
      FirebaseRemoteConfig firebaseRemoteConfig) {
    instance.firebaseRemoteConfig = firebaseRemoteConfig;
  }

  @InjectedFieldSignature("com.project.schedule.fragments.MainFragment.db")
  public static void injectDb(MainFragment instance, AppDb db) {
    instance.db = db;
  }

  @InjectedFieldSignature("com.project.schedule.fragments.MainFragment.gsonUtil")
  public static void injectGsonUtil(MainFragment instance, GsonUtil gsonUtil) {
    instance.gsonUtil = gsonUtil;
  }
}
