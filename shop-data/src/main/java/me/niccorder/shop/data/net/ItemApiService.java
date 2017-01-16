package me.niccorder.shop.data.net;

import java.util.List;
import me.niccorder.shop.data.net.api.ItemService;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.model.DomainItemModel;
import retrofit2.Retrofit;
import rx.Observable;

public class ItemApiService implements ItemRepository {

  private ItemService mItemService;

  public ItemApiService(final Retrofit retrofit) {
    mItemService = retrofit.create(ItemService.class);
  }

  @Override public Observable<DomainItemModel> getItem(String id) {
    return Observable.never();
  }

  @Override public Observable<List<DomainItemModel>> getItems(int pageIndex, int pageSize) {
    return mItemService.getItems(pageIndex, pageSize);
  }

  @Override public Observable<List<DomainItemModel>> getItems(String searchTerm) {
    return Observable.never();
  }
}
