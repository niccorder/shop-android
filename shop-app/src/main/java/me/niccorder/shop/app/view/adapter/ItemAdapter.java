package me.niccorder.shop.app.view.adapter;

import com.airbnb.epoxy.SimpleEpoxyAdapter;

public class ItemAdapter extends SimpleEpoxyAdapter {
  public ItemAdapter() {
    super();
    enableDiffing();
    setSpanCount(2);
  }
}
