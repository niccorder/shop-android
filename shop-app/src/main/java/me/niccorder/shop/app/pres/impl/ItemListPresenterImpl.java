package me.niccorder.shop.app.pres.impl;

import javax.inject.Inject;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.model.ViewModelMapper;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.view.ListItemView;
import me.niccorder.shop.domain.api.ItemRepository;

/**
 * Implementation of {@link ItemListPresenter} that will actually preform the contract that the
 * {@link ItemListPresenter provides.}
 */
public class ItemListPresenterImpl implements ItemListPresenter {

  /**
   * Inject the repository that this presenter will be using. It is up to dagger to delegate where
   * our {@link me.niccorder.shop.domain.api.ItemRepository} is requesting data from.
   */
  @Inject ItemRepository itemRepository;

  /**
   * A view model mapper that reduces the burden of mapping items to and from each respective
   * model
   */
  @Inject ViewModelMapper modelMapper;

  /**
   * Our view that this presenter is managing.
   */
  private ListItemView view;

  /** It is the view's job to attach iteself to the presenter. */
  public void setView(ListItemView view) {
    this.view = view;
  }

  @Override public void onItemClicked(ViewItemModel model) {
    // TODO: 1/16/17 Implement click functionality
  }

  @Override public void refreshAllItems() {
    // TODO: 1/16/17 Handle logic for refreshing all items in the list.
  }

  @Override public void create() {
    itemRepository.getItems(0, 10).map(modelMapper::mapFromDomain).subscribe(view::addItems);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  @Override public void destroy() {

  }
}
