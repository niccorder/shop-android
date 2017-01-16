package me.niccorder.shop.app.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.inject.Singleton;
import me.niccorder.shop.app.view.adapter.model.ItemHolder;
import me.niccorder.shop.app.view.adapter.model.ItemHolder_;
import me.niccorder.shop.domain.model.DomainItemModel;

/**
 * A simplistic utility class that is used to map domain & view-holder models into our view-layer
 * model.
 */
@Singleton public class ViewModelMapper {

  public ViewModelMapper() {
  }

  public ViewItemModel mapFrom(DomainItemModel domainItemModel) {
    return new ViewItemModel(domainItemModel.getId(), domainItemModel.getName(),
        domainItemModel.getDescription(), domainItemModel.getPrice());
  }

  public List<ViewItemModel> mapFromDomain(List<DomainItemModel> domainItemModels) {
    final List<ViewItemModel> viewModelList = new ArrayList<>(domainItemModels.size());
    for (DomainItemModel model : domainItemModels) {
      viewModelList.add(new ViewItemModel(model.getId(), model.getName(), model.getDescription(),
          model.getPrice()));
    }
    return viewModelList;
  }

  public ViewItemModel mapFrom(ItemHolder itemHolder) {
    return new ViewItemModel(itemHolder.itemId, itemHolder.name, itemHolder.description,
        itemHolder.price);
  }

  public List<ViewItemModel> mapFromHolder(List<ItemHolder> itemHolders) {
    final List<ViewItemModel> viewModelList = new ArrayList<>(itemHolders.size());
    for (ItemHolder holder : itemHolders) {
      viewModelList.add(new ViewItemModel(holder.itemId, holder.name, holder.description,
          holder.price));
    }
    return viewModelList;
  }

  public ItemHolder mapToHolder(ViewItemModel model) {
    return new ItemHolder_().itemId(model.id)
        .name(model.name)
        .price(model.price)
        .description(model.description);
  }

  public DomainItemModel mapToDomain(ViewItemModel model) {
    return new DomainItemModel(model.id, model.name, model.price, model.description);
  }
}
