package me.niccorder.shop.data.api;

import java.util.List;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.model.ItemModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ItemService extends ItemRepository {

  @GET("/item/{pageIndex}/{pageSize}") @Override Observable<List<ItemModel>> getItems(
      @Path("pageIndex") final int pageIndex, @Path("pageSize") final int pageSize);
}
