package me.niccorder.shop.data.net;

import java.util.List;
import me.niccorder.shop.data.net.api.ItemService;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.model.DomainItemModel;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * A simple implementation of the domain layers {@link ItemRepository}. This enables us to not
 * break
 * the law of dependency flow, but provides us a way to communicate between barriers. As you can
 * see, this means the data layer is dependant on the domain layer, but the domain layer is
 * <b<NOT</b> dependant on the data layer.
 *
 * As of right now this class is extremely bare because we don't do important things like
 * retry-logic, and propogating errors. It may seem like this class is useless, but please imagine
 * how this class will look if we go ahead and handle network error logic.
 */
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

  /** Returns all items from our rest endpoint. */
  @Override public Observable<List<DomainItemModel>> getAllItems() {
    return mItemService.getItems();
  }
}
