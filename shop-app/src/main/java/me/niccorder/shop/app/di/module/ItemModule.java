package me.niccorder.shop.app.di.module;

import dagger.Module;
import dagger.Provides;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.pres.impl.ItemListPresenterImpl;
import me.niccorder.shop.app.view.fragment.ItemListFragment;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import me.niccorder.shop.domain.interactor.GetItemInteractor;
import me.niccorder.shop.util.di.PerActivity;

/**
 * A module to wrap dependencies relating to Items.
 */
@Module public class ItemModule {

  public ItemModule() {
  }

  @PerActivity @Provides ItemListPresenter provideItemListPresenter() {
    return new ItemListPresenterImpl();
  }

  @PerActivity @Provides GetItemInteractor provideGetItemInteractor(
      final ExecutionThread executionThread, final PostExecutionThread postExecutionThread,
      final ItemRepository itemRepository) {
    return new GetItemInteractor(executionThread, postExecutionThread, itemRepository);
  }
}
