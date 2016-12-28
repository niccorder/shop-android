package me.niccorder.shop.app.di.compontents;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import me.niccorder.shop.app.pres.AbstractActivity;
import me.niccorder.shop.app.di.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(AbstractActivity abstractActivity);

  Context context();
}
