package me.niccorder.shop.app.view.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import butterknife.BindView;
import javax.inject.Inject;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.di.compontents.ActivityComponent;
import me.niccorder.shop.app.di.compontents.DaggerActivityComponent;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.pres.impl.MainPresenterImpl;
import me.niccorder.shop.app.view.MenuView;
import me.niccorder.shop.app.view.fragment.ItemListFragment;
import me.niccorder.shop.app.view.fragment.NotYetImplmentedFragment;
import me.niccorder.shop.data.di.component.DaggerDataComponent;
import me.niccorder.shop.util.di.HasComponent;

/** Currently waiting to finish the first microservice endpoint to implement */
public class MainActivity extends AbstractActivity
    implements MenuView, HasComponent<ActivityComponent> {

  private static final int POSITION_SEARCH = 0;
  private static final int POSITION_POPULAR = 1;
  private static final int POSITION_CART = 2;

  @Inject MainPresenterImpl mPresenter;

  @BindView(R.id.navigation_bar) BottomNavigationView mBottomBar;
  @BindView(R.id.container) ViewPager mFragmentPager;

  protected MainViewPagerAdapter mAdapter;
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

    mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
    mFragmentPager.setAdapter(mAdapter);
    mFragmentPager.setCurrentItem(POSITION_POPULAR);
    mFragmentPager.setOffscreenPageLimit(1);

    mBottomBar.setOnNavigationItemSelectedListener(
        item -> mPresenter.onItemSelected(item.getItemId()));

    mPresenter.setView(this);
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
    int itemPosition = getPositionFromId(itemId);

    mFragmentPager.setCurrentItem(itemPosition);
  }

  private int getPositionFromId(int itemId) {
    switch (itemId) {
      case R.id.item_search:
        return POSITION_SEARCH;
      case R.id.item_shop:
        return POSITION_POPULAR;
      case R.id.item_checkout:
        return POSITION_CART;
    }
    return MainViewPagerAdapter.POSITION_NONE;
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
        .applicationComponent(getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
    mActivityComponent.inject(this);
  }

  @Override public ActivityComponent getComponent() {
    return mActivityComponent;
  }

  private static class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    public MainViewPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      switch (position) {
        case POSITION_SEARCH:
          return NotYetImplmentedFragment.newInstance("Search");
        case POSITION_POPULAR:
          return new ItemListFragment();
        case POSITION_CART:
          return NotYetImplmentedFragment.newInstance("Cart");
      }
      return null;
    }

    @Override public int getCount() {
      return 3;
    }
  }
}
