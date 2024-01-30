package com.project.schedule.di;

import com.project.schedule.utils.GsonUtil;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class GsonModule_ProvideGsonUtilFactory implements Factory<GsonUtil> {
  @Override
  public GsonUtil get() {
    return provideGsonUtil();
  }

  public static GsonModule_ProvideGsonUtilFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GsonUtil provideGsonUtil() {
    return Preconditions.checkNotNullFromProvides(GsonModule.INSTANCE.provideGsonUtil());
  }

  private static final class InstanceHolder {
    private static final GsonModule_ProvideGsonUtilFactory INSTANCE = new GsonModule_ProvideGsonUtilFactory();
  }
}
