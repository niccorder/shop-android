package me.niccorder.shop.app.view.adapter.model;

import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import me.niccorder.shop.app.R;

public class ItemHolder extends EpoxyModelWithHolder<ItemHolder.ItemViewHolder> {

  @EpoxyAttribute String itemId;
  @EpoxyAttribute String name;
  @EpoxyAttribute @Nullable String description;
  @EpoxyAttribute float price;

  @Override protected ItemViewHolder createNewHolder() {
    return new ItemViewHolder();
  }

  @Override protected int getDefaultLayout() {
    return R.layout.view_item_basic;
  }

  public static class ItemViewHolder extends BaseViewHolder {
    @BindView(R.id.title) TextView mTitle;
  }
}
