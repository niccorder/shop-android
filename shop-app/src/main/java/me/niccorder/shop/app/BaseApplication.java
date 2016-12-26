package me.niccorder.shop.app;

import android.app.Application;
import me.niccorder.shop.app.di.ApplicationModule;
import me.niccorder.shop.app.di.compontents.ApplicationComponent;
import me.niccorder.shop.app.di.compontents.DaggerApplicationComponent;

public class BaseApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    // Init dependency injection.
    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }
}
