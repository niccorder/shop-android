package me.niccorder.shop.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import me.niccorder.shop.app.R;

public class NotYetImplmentedFragment extends AbstractFragment {

  private String mComponentName;

  public static NotYetImplmentedFragment newInstance(final String componentName) {
    final Bundle bundle = new Bundle();
    bundle.putString(Intent.EXTRA_TEXT, componentName);

    final NotYetImplmentedFragment fragment = new NotYetImplmentedFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getArguments() != null && getArguments().containsKey(Intent.EXTRA_TEXT)) {
      mComponentName = getArguments().getString(Intent.EXTRA_TEXT);
    }
  }

  @Override protected int provideLayoutId() {
    return R.layout.layout_not_yet_implemented;
  }

  @Override protected String provideLogTag() {
    return String.format("NotYetImplementedFragment (%s)",
        mComponentName == null ? "" : mComponentName);
  }
}
