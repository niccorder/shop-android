package me.niccorder.shop.domain.api;

import java.util.List;
import me.niccorder.shop.domain.model.DomainItemModel;
import rx.Observable;

public interface ItemRepository {
  Observable<DomainItemModel> getItem(final String id);

  Observable<List<DomainItemModel>> getItems(final int pageIndex, final int pageSize);

  Observable<List<DomainItemModel>> getItems(final String searchTerm);
}
