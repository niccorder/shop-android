package me.niccorder.shop.app.view;

import java.util.Collection;
import me.niccorder.shop.app.model.ViewItemModel;

/**
 * The contract that is applied to showing a list of items. This should be extended, and rarely (if
 * at all) should be implemented as is. This is because we have many different types of child views
 * which will be aggregating, and displaying items in a list, but for for different reasons (i.e.
 * popular list, vs new list).
 *
 * With that being said... I implemented this as is for the first phase of the application to help
 * speed up the process. Don't do what I did.
 */
public interface ListItemView extends BaseView {
  void addItem(ViewItemModel model);

  void addItems(ViewItemModel... models);

  void addItems(Collection<ViewItemModel> models);

  void removeItem(ViewItemModel model);

  void removeItems(ViewItemModel... models);

  void removeAllItems();

  void onDisplayModel(ViewItemModel model);
}
