package me.niccorder.shop.app.view;

import java.util.Collection;
import me.niccorder.shop.app.model.ViewItemModel;

public interface ListItemView extends BaseView {
  void addItem(ViewItemModel model);

  void addItems(ViewItemModel... models);

  void addItems(Collection<ViewItemModel> models);

  void removeItem(ViewItemModel model);

  void removeItems(ViewItemModel... models);

  void removeAllItems();

  void onDisplayModel(ViewItemModel model);
}
