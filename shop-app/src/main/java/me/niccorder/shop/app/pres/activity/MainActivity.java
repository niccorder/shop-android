package me.niccorder.shop.app.pres.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import butterknife.BindView;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.pres.AbstractActivity;

public class MainActivity extends AbstractActivity {

  @BindView(R.id.navigation_bar) BottomNavigationView mBottomBar;

  @Override protected String provideLogTag() {
    return "MainActivity";
  }

  @Override protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBottomBar.
  }

}
