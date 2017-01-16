package me.niccorder.shop.app.view.adapter;

import com.airbnb.epoxy.SimpleEpoxyAdapter;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.view.adapter.model.ItemHolder_;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemAdapter extends SimpleEpoxyAdapter {
  public ItemAdapter() {
    super();
  }

  /** Converts model into a holder model asynchronously */
  public void addItems(ViewItemModel... models) {
    Observable.from(models)
        .map(model -> new ItemHolder_().itemId(model.id)
            .description(model.description)
            .price(model.price)
            .name(model.name))
        .toList()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::addModels);
  }

  public void addItem(ViewItemModel model) {
    addModel(new ItemHolder_().itemId(model.id)
        .name(model.name)
        .description(model.description)
        .price(model.price));
  }

  //// TODO: 1/15/17 Implement remove items & click features.
}
