package me.niccorder.shop.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.niccorder.shop.util.di.HasComponent;
import timber.log.Timber;

/**
 * A base fragment which all child fragments should extend from. This allows us to reduce code
 * bloat, provide an easy way to inject dependencies, injects our views for us, and also manages
 * the
 * releasing of strong references that are created when injecting views.
 */
public abstract class AbstractFragment extends Fragment {

  /** Since fragments have a different lifecycle than activities, we need to release our view */
  private Unbinder mUnbinder;

  /** @return the layout id for this fragment, or -1 to flag there is no layout. */
  protected abstract int provideLayoutId();

  /** @return a String that will represent this fragment in logging. */
  protected abstract String provideLogTag();

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Timber.d(provideLogTag(), "onCreate()");
  }

  /**
   * Ease of use capability to allow extending fragments to not have more code bloat than
   * necessary.
   */
  @CallSuper @Nullable @Override public View onCreateView(LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    Timber.d(provideLogTag(), "onCreateView()");
    return inflater.inflate(provideLayoutId(), container, false);
  }

  /** Injects the view using butterknife. This creates strong references that must be released */
  @CallSuper @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Timber.d(provideLogTag(), "onViewCreated()");

    // Inject the view
    Timber.v(provideLogTag(), "Injecting fragment's view");
    mUnbinder = ButterKnife.bind(this, view);
  }

  @Override public void onResume() {
    super.onResume();
    Timber.d(provideLogTag(), "onResume()");
  }

  @Override public void onPause() {
    super.onPause();
    Timber.d(provideLogTag(), "onPause()");
  }

  /** Releases our strong references as to allow for GC */
  @CallSuper @Override public void onDestroyView() {
    super.onDestroyView();
    Timber.d(provideLogTag(), "onDestroyView()");

    Timber.v(provideLogTag(), "release injected view.");
    mUnbinder.unbind();
  }

  /** Gets a component for dependency injection by its type. */
  @SuppressWarnings("unchecked") protected <C> C getComponent(Class<C> componentType) {
    Timber.d(provideLogTag(), "getComponent()");
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }

  protected int getDimensionPixelSize(@DimenRes int dimensionRes) {
    return getResources().getDimensionPixelSize(dimensionRes);
  }
}
