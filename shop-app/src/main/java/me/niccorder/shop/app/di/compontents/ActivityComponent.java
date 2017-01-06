package me.niccorder.shop.app.di.compontents;

import android.support.v7.app.AppCompatActivity;
import dagger.Component;
import me.niccorder.shop.app.di.PerActivity;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.view.activity.MainActivity;
import me.niccorder.shop.domain.interactor.GetItemInteractor;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(MainActivity activity);

  AppCompatActivity activity();
  GetItemInteractor getItemInteractor();
}
