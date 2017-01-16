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

  @Inject ItemRepository itemRepository;
  @Inject ViewModelMapper modelMapper;

  private ListItemView view;

  public void setView(ListItemView view) {
    this.view = view;
  }

  @Override public void onItemClicked(ViewItemModel model) {

  }

  @Override public void refreshAllItems() {

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
