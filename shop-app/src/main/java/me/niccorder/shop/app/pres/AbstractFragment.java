package me.niccorder.shop.app.pres;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class AbstractFragment extends Fragment {

  /** Since fragments have a different lifecycle than activities, we need to release our view */
  private Unbinder mUnbinder;

  /** @return the layout id for this fragment, or -1 to flag there is no layout. */
  protected abstract int provideLayoutId();

  /** @return a String that will represent this fragment in logging. */
  protected abstract String provideLogTag();

  @CallSuper @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(provideLayoutId(), container, false);
  }

  @CallSuper @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Inject the view
    mUnbinder = ButterKnife.bind(this, view);
  }

  @CallSuper @Override public void onDestroyView() {
    super.onDestroyView();

    // Release strong references created from view injection.
    mUnbinder.unbind();
    mUnbinder = null;
  }
}
