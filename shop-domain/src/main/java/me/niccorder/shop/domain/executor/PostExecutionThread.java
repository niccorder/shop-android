package me.niccorder.shop.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {
  Scheduler getScheduler();
}
