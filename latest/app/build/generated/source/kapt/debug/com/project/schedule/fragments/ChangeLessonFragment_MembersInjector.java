package com.project.schedule.fragments;

import com.project.schedule.db.AppDb;
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
public final class ChangeLessonFragment_MembersInjector implements MembersInjector<ChangeLessonFragment> {
  private final Provider<AppDb> dbProvider;

  public ChangeLessonFragment_MembersInjector(Provider<AppDb> dbProvider) {
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<ChangeLessonFragment> create(Provider<AppDb> dbProvider) {
    return new ChangeLessonFragment_MembersInjector(dbProvider);
  }

  @Override
  public void injectMembers(ChangeLessonFragment instance) {
    injectDb(instance, dbProvider.get());
  }

  @InjectedFieldSignature("com.project.schedule.fragments.ChangeLessonFragment.db")
  public static void injectDb(ChangeLessonFragment instance, AppDb db) {
    instance.db = db;
  }
}
