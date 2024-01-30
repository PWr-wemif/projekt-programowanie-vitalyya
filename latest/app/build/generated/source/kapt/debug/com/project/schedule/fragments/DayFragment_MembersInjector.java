package com.project.schedule.fragments;

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
public final class DayFragment_MembersInjector implements MembersInjector<DayFragment> {
  private final Provider<GsonUtil> gsonUtilProvider;

  public DayFragment_MembersInjector(Provider<GsonUtil> gsonUtilProvider) {
    this.gsonUtilProvider = gsonUtilProvider;
  }

  public static MembersInjector<DayFragment> create(Provider<GsonUtil> gsonUtilProvider) {
    return new DayFragment_MembersInjector(gsonUtilProvider);
  }

  @Override
  public void injectMembers(DayFragment instance) {
    injectGsonUtil(instance, gsonUtilProvider.get());
  }

  @InjectedFieldSignature("com.project.schedule.fragments.DayFragment.gsonUtil")
  public static void injectGsonUtil(DayFragment instance, GsonUtil gsonUtil) {
    instance.gsonUtil = gsonUtil;
  }
}
