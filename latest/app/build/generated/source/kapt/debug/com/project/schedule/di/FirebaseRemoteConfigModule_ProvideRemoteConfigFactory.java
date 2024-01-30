package com.project.schedule.di;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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
public final class FirebaseRemoteConfigModule_ProvideRemoteConfigFactory implements Factory<FirebaseRemoteConfig> {
  @Override
  public FirebaseRemoteConfig get() {
    return provideRemoteConfig();
  }

  public static FirebaseRemoteConfigModule_ProvideRemoteConfigFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseRemoteConfig provideRemoteConfig() {
    return Preconditions.checkNotNullFromProvides(FirebaseRemoteConfigModule.INSTANCE.provideRemoteConfig());
  }

  private static final class InstanceHolder {
    private static final FirebaseRemoteConfigModule_ProvideRemoteConfigFactory INSTANCE = new FirebaseRemoteConfigModule_ProvideRemoteConfigFactory();
  }
}
