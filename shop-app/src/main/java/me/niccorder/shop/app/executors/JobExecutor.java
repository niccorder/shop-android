package me.niccorder.shop.app.executors;

import android.support.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.niccorder.shop.domain.executor.ExecutionThread;

/** Allows us to run procs in the background */
public class JobExecutor implements ExecutionThread {

  private final ThreadPoolExecutor threadPoolExecutor;

  @Inject JobExecutor() {
    this.threadPoolExecutor =
        new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
            new JobThreadFactory());
  }

  @Override public void execute(Runnable command) {

  }

  private static class JobThreadFactory implements ThreadFactory {
    private int counter = 0;

    @Override public Thread newThread(@NonNull Runnable runnable) {
      return new Thread(runnable, "shop_" + counter++);
    }
  }
}
