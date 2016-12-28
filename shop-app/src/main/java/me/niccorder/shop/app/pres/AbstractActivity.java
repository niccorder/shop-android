package me.niccorder.shop.app.pres;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class AbstractActivity extends AppCompatActivity {

  /** @return the tag that will show in logcat. */
  protected abstract String provideLogTag();

  /** @return the layout id for this activity */
  @LayoutRes protected abstract int provideLayoutId();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Allows us to use butterknife to generate code to inflate/bind views.
    ButterKnife.bind(this);
  }

}
