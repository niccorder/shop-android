package me.niccorder.shop.app.pres.impl;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.model.ViewModelMapper;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.view.BaseView;
import me.niccorder.shop.app.view.ListItemView;
import me.niccorder.shop.domain.interactor.GetItemInteractor;
import me.niccorder.shop.domain.model.DomainItemModel;
import rx.functions.Action1;
import timber.log.Timber;

/**
 * Implementation of {@link ItemListPresenter} that will actually preform the contract that the
 * {@link ItemListPresenter provides.}
 */
public class ItemListPresenterImpl implements ItemListPresenter<ListItemView> {

  /** Our interactor that our presenter will be using */
  private GetItemInteractor getItemInteractor;

  /**
   * Our view that this presenter is managing.
   */
  private ListItemView view;

  /**
   * Dagger will inject our object since we have this annotated.
   */
  @Inject public ItemListPresenterImpl(GetItemInteractor getItemInteractor) {
    this.getItemInteractor = getItemInteractor;
  }

  /** The view is responsible for attaching/detaching itself. */
  @Override public void setView(ListItemView view) {
    this.view = view;
  }

  @Override public void onItemClicked(ViewItemModel model) {
    // TODO: 1/16/17 Implement click functionality
  }

  @Override public void refreshAllItems() {
    Timber.d("refreshAllItems()");
    getItemInteractor.getAllItems().subscribe(s -> {
      Timber.d("Received items! [%s]", Arrays.toString(s.toArray()));
      view.addItems(s);
    }, throwable -> Timber.e(throwable, "There was an error in our network request."));
  }

  @Override public void create() {
  }

  @Override public void resume() {
    getItemInteractor.getAllItems().subscribe(s -> {
      Timber.d("Received items! [%s]", Arrays.toString(s.toArray()));
      view.addItems(s);
    }, throwable -> Timber.e(throwable, "There was an error in our network request."));
  }

  @Override public void pause() {

  }

  @Override public void destroy() {

  }
}
