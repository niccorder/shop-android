package me.niccorder.shop.domain.interactor;

import com.google.common.base.Optional;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;
import me.niccorder.shop.domain.util.Params;
import rx.Observable;

public class GetItemInteractor extends AbstractInteractor {

  private static final String KEY_ITEM_ID = "key_item_id";

  private final ItemRepository itemRepository;

  public GetItemInteractor(
      ExecutionThread executionThread,
      PostExecutionThread postExecutionThread,
      ItemRepository itemRepository
  ) {
    super(executionThread, postExecutionThread);
    this.itemRepository = itemRepository;
  }

  @Override public Observable create(Optional<Params> parameters) {
    if(parameters.isPresent()) {
      final String itemId = parameters.get().getString(KEY_ITEM_ID);
      return itemRepository.getItem(itemId);
    } else {
      return itemRepository.getItems(0, 10);
    }
  }
}
