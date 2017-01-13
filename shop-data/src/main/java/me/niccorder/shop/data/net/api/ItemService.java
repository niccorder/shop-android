package me.niccorder.shop.data.net.api;

import java.util.List;
import me.niccorder.shop.domain.model.ItemModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ItemService {

  @GET("/item/{pageIndex}/{pageSize}") Observable<List<ItemModel>> getItems(
      @Path("pageIndex") final int pageIndex, @Path("pageSize") final int pageSize);
}
