package me.niccorder.shop.app;

import android.app.Application;
import butterknife.ButterKnife;
import com.squareup.leakcanary.LeakCanary;
import me.niccorder.shop.app.di.compontents.ApplicationComponent;
import me.niccorder.shop.app.di.compontents.DaggerApplicationComponent;
import me.niccorder.shop.app.di.module.ApplicationModule;
import me.niccorder.shop.data.di.module.DataModule;
import timber.log.Timber;

/**
 * The base of our application. We initialize application wide components, features and dependencies
 * at this time. Things like logging, leak detection, and of course dependency injection as well
 * :-)
 */
public class BaseApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  /** <a href="https://www.youtube.com/watch?v=30w5pw8Dg7Q">Right you are ken.</a> */
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

  /** Injects classes using dagger2 <a href="https://google.github.io/dagger/"/> */
  private void injectDependencies() {
    mApplicationComponent = DaggerApplicationComponent.builder()
        .dataModule(new DataModule("http://7216ccd7.ngrok.io"))
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  /** Timber is an awesome wrapper to android's LogCat <a href="https://github.com/jakewharton/timber"/> */
  private void initLogging() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  /**
   * Butterknife is a view injection/code generation tool from jake wharton. Its a life-saver.
   * <a href="http://jakewharton.github.io/butterknife/" />
   */
  private void injectViews() {
    ButterKnife.setDebug(BuildConfig.DEBUG);
  }

  /** Provides the application graph to inject-ee's */
  public ApplicationComponent getApplicationComponent() {
    return this.mApplicationComponent;
  }
}
