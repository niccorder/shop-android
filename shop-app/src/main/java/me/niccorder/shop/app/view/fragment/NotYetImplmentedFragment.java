package me.niccorder.shop.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import me.niccorder.shop.app.R;

/**
 * This is basically a stub fragment that allows us to stub out features which are not yet created.
 * It helps in the development process since you can basically fake it 'till you make it, in the
 * literal sense of the phrase :-)
 */
public class NotYetImplmentedFragment extends AbstractFragment {

  private String mComponentName;

  /**
   * Pass in the name of the feature that this is mocking for you so we can log that our to logcat
   * to help debugging (if necessary). The component name is nullable if you is a lazy punk ass
   * bitch.
   */
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
