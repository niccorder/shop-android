package me.niccorder.shop.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

  /** @return the tag that will show in logcat. */
  protected abstract String provideLogTag();

  /** @return the layout id for this activity */
  @LayoutRes protected abstract int provideLayoutId();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

}
