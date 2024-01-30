package com.project.schedule.di;

import com.project.schedule.utils.CalendarUtil;
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
public final class CalendarModule_ProvideCalendarFactory implements Factory<CalendarUtil> {
  @Override
  public CalendarUtil get() {
    return provideCalendar();
  }

  public static CalendarModule_ProvideCalendarFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CalendarUtil provideCalendar() {
    return Preconditions.checkNotNullFromProvides(CalendarModule.INSTANCE.provideCalendar());
  }

  private static final class InstanceHolder {
    private static final CalendarModule_ProvideCalendarFactory INSTANCE = new CalendarModule_ProvideCalendarFactory();
  }
}
