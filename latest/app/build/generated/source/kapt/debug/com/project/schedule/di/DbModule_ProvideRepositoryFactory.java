package com.project.schedule.di;

import com.project.schedule.db.AppDb;
import com.project.schedule.repository.LessonRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DbModule_ProvideRepositoryFactory implements Factory<LessonRepository> {
  private final Provider<AppDb> appDbProvider;

  public DbModule_ProvideRepositoryFactory(Provider<AppDb> appDbProvider) {
    this.appDbProvider = appDbProvider;
  }

  @Override
  public LessonRepository get() {
    return provideRepository(appDbProvider.get());
  }

  public static DbModule_ProvideRepositoryFactory create(Provider<AppDb> appDbProvider) {
    return new DbModule_ProvideRepositoryFactory(appDbProvider);
  }

  public static LessonRepository provideRepository(AppDb appDb) {
    return Preconditions.checkNotNullFromProvides(DbModule.INSTANCE.provideRepository(appDb));
  }
}
