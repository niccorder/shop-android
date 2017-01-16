package me.niccorder.shop.app.view.adapter.model;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import me.niccorder.shop.app.R;

/**
 * A ViewHolder which extends from the EpoxyViewHolder library. Epoxy will create a companion
 * object
 * that will provide builder-like functionality to our holder for easier use. This is mainly used
 * by
 * Epoxy to inflate the layouts, and handle item  interactions such as onlick.
 */
public class ItemHolder extends EpoxyModelWithHolder<ItemHolder.ItemViewHolder> {

  @EpoxyAttribute public String itemId;
  @EpoxyAttribute public String name;
  @EpoxyAttribute @Nullable public String description;
  @EpoxyAttribute public float price;
  @EpoxyAttribute @Nullable View.OnClickListener clickListener;

  @Override protected ItemViewHolder createNewHolder() {
    return new ItemViewHolder();
  }

  @Override protected int getDefaultLayout() {
    return R.layout.view_item_basic;
  }

  @Override public void bind(ItemViewHolder holder) {
    super.bind(holder);
    holder.title.setText(name);
    holder.caption.setText(description);
    holder.itemView.setOnClickListener(clickListener);
  }

  static class ItemViewHolder extends BaseViewHolder {
    @BindView(R.id.title_text) TextView title;
    @BindView(R.id.caption_text) TextView caption;
  }
}
