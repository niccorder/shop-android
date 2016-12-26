package me.niccorder.shop.app.di.compontents;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import me.niccorder.shop.app.BaseActivity;
import me.niccorder.shop.app.di.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  Context context();
}
