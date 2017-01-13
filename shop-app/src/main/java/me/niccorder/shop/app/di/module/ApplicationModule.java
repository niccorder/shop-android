package me.niccorder.shop.app.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.niccorder.shop.app.executors.JobExecutor;
import me.niccorder.shop.app.executors.MainThread;
import me.niccorder.shop.data.di.module.DataModule;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;

@Module public class ApplicationModule {

  private Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides @Singleton Application provideApplication() {
    return mApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return mApplication;
  }

  @Provides @Singleton ExecutionThread provideExecutionThread(final JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread() {
    return new MainThread();
  }
}
