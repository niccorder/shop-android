package me.niccorder.shop.domain.api;

import java.util.List;
import me.niccorder.shop.domain.model.ItemModel;
import rx.Observable;

public interface ItemRepository {
  Observable<ItemModel> getItem(final String id);

  Observable<List<ItemModel>> getItems(final int pageIndex, final int pageSize);

  Observable<List<ItemModel>> getItems(final String searchTerm);
}
