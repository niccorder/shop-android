package me.niccorder.shop.app.model;

import android.support.annotation.CallSuper;
import android.view.View;
import butterknife.ButterKnife;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModel;

/**
 * Base holder that all models should extend from.
 */
public abstract class AbstractAdapterModel extends EpoxyHolder {

  @CallSuper @Override protected void bindView(View itemView) {
    ButterKnife.bind(itemView);
  }
}
