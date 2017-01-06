package me.niccorder.shop.app.view.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import me.niccorder.shop.app.BaseApplication;
import me.niccorder.shop.app.di.compontents.ApplicationComponent;
import timber.log.Timber;

public abstract class AbstractActivity extends AppCompatActivity {

  /** @return the tag that will show in logcat. */
  protected abstract String provideLogTag();

  /** @return the layout id for this activity */
  @LayoutRes protected abstract int provideLayoutId();

  @CallSuper @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(provideLayoutId());

    // Injects view field members.
    ButterKnife.bind(this);
  }

  /** Get the Main Application component for dependency injection. */
  protected ApplicationComponent getApplicationComponent() {
    return ((BaseApplication) getApplication()).getApplicationComponent();
  }

  /** Slight helper method to add a fragment. */
  protected void addFragment(@IdRes int containerViewId, Fragment fragment) {
    getSupportFragmentManager().beginTransaction().add(containerViewId, fragment).commit();
  }

  /** Slight helper method to add a replace. */
  protected void replaceFragment(@IdRes int containerViewId, Fragment fragment) {
    getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment).commit();
  }
}
