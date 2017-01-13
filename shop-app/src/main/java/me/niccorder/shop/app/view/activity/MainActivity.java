package me.niccorder.shop.app.view.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import butterknife.BindView;
import javax.inject.Inject;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.di.compontents.ActivityComponent;
import me.niccorder.shop.app.di.compontents.DaggerActivityComponent;
import me.niccorder.shop.app.di.compontents.DaggerItemComponent;
import me.niccorder.shop.app.di.compontents.ItemComponent;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.pres.impl.MainPresenterImpl;
import me.niccorder.shop.app.view.MenuView;
import me.niccorder.shop.util.di.HasComponent;

/** Currently waiting to finish the first microservice endpoint to implement */
public class MainActivity extends AbstractActivity
    implements MenuView, HasComponent<ItemComponent> {

  @Inject MainPresenterImpl mPresenter;

  @BindView(R.id.navigation_bar) BottomNavigationView mBottomBar;

  private ActivityComponent mActivityComponent;

  @Override protected String provideLogTag() {
    return "MainActivity";
  }

  @Override protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initInjection();
    mActivityComponent.inject(this);

    mBottomBar.setOnNavigationItemSelectedListener(
        item -> mPresenter.onItemSelected(item.getItemId()));
  }

  @Override protected void onResume() {
    super.onResume();

    mPresenter.resume();
  }

  @Override protected void onPause() {
    super.onPause();

    mPresenter.pause();
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    mPresenter.destroy();
  }

  @Override public void selectItem(int itemId) {
    mBottomBar.getMenu().findItem(itemId).setChecked(true);
  }

  @Override public void deselectItem(int itemId) {
    mBottomBar.getMenu().findItem(itemId).setChecked(false);
  }

  @Override public void showLoading(boolean show) {
    //TODO
  }

  @Override public void showNetworkError(boolean show) {
    //TODO
  }

  private void initInjection() {
    this.mActivityComponent = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .applicationComponent(getApplicationComponent())
        .build();
  }

  @Override public ItemComponent getComponent() {
    return DaggerItemComponent.builder().applicationComponent(getApplicationComponent()).build();
  }
}
