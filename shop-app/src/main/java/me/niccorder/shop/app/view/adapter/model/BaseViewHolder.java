package me.niccorder.shop.app.view.adapter.model;

import android.support.annotation.CallSuper;
import android.view.View;
import butterknife.ButterKnife;
import com.airbnb.epoxy.EpoxyHolder;

/**
 * Base holder that all models should extend from.
 */
abstract class BaseViewHolder extends EpoxyHolder {

  protected View itemView;

  @CallSuper @Override protected void bindView(View itemView) {
    ButterKnife.bind(this, itemView);
    this.itemView = itemView;
  }
}
