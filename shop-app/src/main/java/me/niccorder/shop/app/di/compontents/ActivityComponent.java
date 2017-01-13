package me.niccorder.shop.app.di.compontents;

import android.support.v7.app.AppCompatActivity;
import dagger.Component;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.view.activity.MainActivity;
import me.niccorder.shop.data.di.component.DataComponent;
import me.niccorder.shop.data.di.module.DataModule;
import me.niccorder.shop.util.di.PerActivity;

@Component(dependencies = {
    ApplicationComponent.class, DataComponent.class
}, modules = ActivityModule.class) public interface ActivityComponent {
  void inject(MainActivity activity);

  AppCompatActivity activity();
}
