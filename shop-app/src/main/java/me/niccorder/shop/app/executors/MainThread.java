package me.niccorder.shop.app.executors;

import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Scheduler;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import rx.android.schedulers.AndroidSchedulers;

/** Our main thread wrapper used for executing use-case callbacks on UI thread. */
@Singleton public class MainThread implements PostExecutionThread {

  @Inject public MainThread() {
  }

  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
