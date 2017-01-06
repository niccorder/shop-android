package me.niccorder.shop.app;

import android.app.Application;
import butterknife.ButterKnife;
import com.squareup.leakcanary.LeakCanary;
import me.niccorder.shop.app.di.compontents.ApplicationComponent;
import me.niccorder.shop.app.di.compontents.DaggerApplicationComponent;
import me.niccorder.shop.app.di.module.ApplicationModule;
import timber.log.Timber;

public class BaseApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    injectDependencies();
    initLeakCanary();
    initLogging();
    injectViews();
  }

  /** Init leak canary <a href="https://github.com/square/leakcanary#getting-started"/> */
  private void initLeakCanary() {
    if (!LeakCanary.isInAnalyzerProcess(this)) {
      LeakCanary.install(this);
    }
  }

  /** Injects classes using dagger2 */
  private void injectDependencies() {
    mApplicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  /** Timber is an awesome wrapper to android's LogCat <a href="https://github.com/jakewharton/timber"/> */
  private void initLogging() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  /** Butterknife is a view injection/code generation tool from jake wharton. Its a life-saver. */
  private void injectViews() {
    ButterKnife.setDebug(BuildConfig.DEBUG);
  }

  public ApplicationComponent getApplicationComponent() {
    return this.mApplicationComponent;
  }
}
