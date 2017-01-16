package me.niccorder.shop.app.di.module;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import me.niccorder.shop.app.pres.impl.MainPresenterImpl;
import me.niccorder.shop.util.di.PerActivity;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module public class ActivityModule {

  private final AppCompatActivity activity;

  public ActivityModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  /**
   * Expose the activity to dependents in the graph.
   */
  @PerActivity @Provides AppCompatActivity activity() {
    return this.activity;
  }

  @PerActivity @Provides MainPresenterImpl provideMainPresenterImpl() {
    return new MainPresenterImpl();
  }
}