package me.niccorder.shop.app.di.module;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.niccorder.shop.app.pres.impl.MainPresenterImpl;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import me.niccorder.shop.domain.interactor.GetItemInteractor;
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

  @PerActivity @Provides MainPresenterImpl provideMainPresenterImpl(
      GetItemInteractor getItemInteractor) {
    return new MainPresenterImpl(getItemInteractor);
  }

  @PerActivity @Provides GetItemInteractor provideGetItemInteractor(final ExecutionThread executionThread,
      final PostExecutionThread postExecutionThread, final ItemRepository itemRepository) {
    return new GetItemInteractor(executionThread, postExecutionThread, itemRepository);
  }
}