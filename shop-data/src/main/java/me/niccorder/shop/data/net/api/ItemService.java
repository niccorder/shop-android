package me.niccorder.shop.data.net.api;

import java.util.List;
import me.niccorder.shop.domain.model.DomainItemModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ItemService {

  /** Returns all items from our rest endpoint */
  @GET("/item") Observable<List<DomainItemModel>> getItems();

  /** This endpoint has not been implemented yet. */
  @GET("/item/{pageIndex}/{pageSize}") Observable<List<DomainItemModel>> getItems(
      @Path("pageIndex") final int pageIndex, @Path("pageSize") final int pageSize);
}
