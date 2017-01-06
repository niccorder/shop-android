package me.niccorder.shop.app.di.module;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import me.niccorder.shop.app.di.PerActivity;
import me.niccorder.shop.data.ShopClient;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import me.niccorder.shop.domain.interactor.GetItemInteractor;

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
  @Provides @PerActivity AppCompatActivity activity() {
    return this.activity;
  }

  @Provides @PerActivity GetItemInteractor getItemInteractor(final ExecutionThread executionThread,
      final PostExecutionThread postExecutionThread, final ShopClient shopClient) {
    return new GetItemInteractor(executionThread, postExecutionThread, shopClient.getItemService());
  }
}