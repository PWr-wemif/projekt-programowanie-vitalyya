package com.project.schedule;

import com.project.schedule.repository.LessonRepository;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<LessonRepository> lessonRepositoryProvider;

  public MainActivity_MembersInjector(Provider<LessonRepository> lessonRepositoryProvider) {
    this.lessonRepositoryProvider = lessonRepositoryProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<LessonRepository> lessonRepositoryProvider) {
    return new MainActivity_MembersInjector(lessonRepositoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectLessonRepository(instance, lessonRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.project.schedule.MainActivity.lessonRepository")
  public static void injectLessonRepository(MainActivity instance,
      LessonRepository lessonRepository) {
    instance.lessonRepository = lessonRepository;
  }
}
