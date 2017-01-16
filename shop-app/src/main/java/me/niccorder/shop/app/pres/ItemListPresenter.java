package me.niccorder.shop.app.pres;

import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.view.ListItemView;

/**
 * An presenter used with views which will be showing items in a list
 */
public interface ItemListPresenter<T extends ListItemView> extends Presenter<T> {

  void onItemClicked(ViewItemModel model);

  void refreshAllItems();

  // TODO: 1/15/17 Setup pagination once completed api.
}
