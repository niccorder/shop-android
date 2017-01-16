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

  /** Tell epoxy how to create a viewmodel of our type */
  @Override protected ItemViewHolder createNewHolder() {
    return new ItemViewHolder();
  }

  /** Provide the layout for our viewmodel for epoxy to create */
  @Override protected int getDefaultLayout() {
    return R.layout.view_item_basic;
  }

  /** Tell epoxy how to bind data to our view model. */
  @Override public void bind(ItemViewHolder holder) {
    super.bind(holder);
    holder.title.setText(name);
    holder.caption.setText(description);
    holder.itemView.setOnClickListener(clickListener);
  }

  /** View holder pattern used in android to improve list performance */
  static class ItemViewHolder extends BaseViewHolder {
    @BindView(R.id.title_text) TextView title;
    @BindView(R.id.caption_text) TextView caption;
  }
}
