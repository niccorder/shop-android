package me.niccorder.shop.app.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

  Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return mApplication;
  }
}
