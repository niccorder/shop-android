package me.niccorder.shop.domain.interactor;

import com.google.common.base.*;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import me.niccorder.shop.domain.util.Params;
import rx.Observable;
import rx.schedulers.Schedulers;

public abstract class AbstractInteractor {

  private final ExecutionThread executionThread;
  private final PostExecutionThread postExecutionThread;

  public AbstractInteractor(ExecutionThread executionThread,
      PostExecutionThread postExecutionThread) {
    this.executionThread = executionThread;
    this.postExecutionThread = postExecutionThread;
  }

  public abstract Observable create(Optional<Params> parameters);

  public void execute(final Params parameters) {
    final Observable observable = create(Optional.of(parameters))
        .subscribeOn(Schedulers.from(executionThread))
        .observeOn(postExecutionThread.getScheduler());
  }
}
