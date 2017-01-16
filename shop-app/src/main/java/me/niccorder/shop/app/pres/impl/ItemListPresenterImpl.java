package me.niccorder.shop.app.pres.impl;

import java.util.List;
import javax.inject.Inject;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.model.ViewModelMapper;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.view.BaseView;
import me.niccorder.shop.app.view.ListItemView;
import me.niccorder.shop.domain.interactor.GetItemInteractor;

/**
 * Implementation of {@link ItemListPresenter} that will actually preform the contract that the
 * {@link ItemListPresenter provides.}
 */
public class ItemListPresenterImpl implements ItemListPresenter<ListItemView> {

  /** Our interactor that our presenter will be using */
  private GetItemInteractor getItemInteractor;

  /**
   * A view model mapper that reduces the burden of mapping items to and from each respective
   * model
   */
  private ViewModelMapper modelMapper;

  /**
   * Our view that this presenter is managing.
   */
  private ListItemView view;

  /**
   * Dagger will inject our object since we have this annotated.
   */
  @Inject public ItemListPresenterImpl(GetItemInteractor getItemInteractor,
      ViewModelMapper modelMapper) {
    this.getItemInteractor = getItemInteractor;
    this.modelMapper = modelMapper;
  }

  /** The view is responsible for attaching/detaching itself. */
  @Override public void setView(ListItemView view) {
    this.view = view;
  }

  @Override public void onItemClicked(ViewItemModel model) {
    // TODO: 1/16/17 Implement click functionality
  }

  @Override public void refreshAllItems() {
    // TODO: 1/16/17 Handle logic for refreshing all items in the list.
  }

  @Override public void create() {
  }

  @Override public void resume() {
  }

  @Override public void pause() {

  }

  @Override public void destroy() {

  }
}
