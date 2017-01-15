package me.niccorder.shop.app.pres.impl;

import android.support.annotation.NonNull;
import javax.inject.Inject;
import me.niccorder.shop.app.pres.MainPresenter;
import me.niccorder.shop.app.view.MenuView;
import me.niccorder.shop.domain.interactor.GetItemInteractor;
import me.niccorder.shop.util.di.PerActivity;
import timber.log.Timber;

/**
 * The presenter that handles the base activity functions.
 */
public class MainPresenterImpl implements MainPresenter {

  private final GetItemInteractor mItemInteractor;
  private MenuView mMenuView;

  private int mCurrentItemId;

  @Inject public MainPresenterImpl(@NonNull GetItemInteractor itemInteractor) {
    Timber.d("Injecting %s", MainPresenterImpl.class);
    this.mItemInteractor = itemInteractor;
  }

  public void setView(@NonNull MenuView menuView) {
    this.mMenuView = menuView;
  }

  @Override public void create() {
    Timber.v("onCreate()");
    mCurrentItemId = 1;
  }

  @Override public void resume() {
    Timber.v("onResume()");
  }

  @Override public void pause() {
    Timber.v("onPause()");
  }

  @Override public void destroy() {
    mMenuView = null;
    Timber.v("onDestroy()");
  }

  @Override public int getSelectedItemId() {
    Timber.v("getSelectedItemId()");
    return mCurrentItemId;
  }

  @Override public boolean onItemSelected(int itemId) {
    Timber.v("onItemSelected()");
    if (mCurrentItemId != 0) mMenuView.deselectItem(mCurrentItemId);

    int previousItem = mCurrentItemId;
    mCurrentItemId = itemId;
    mMenuView.selectItem(itemId);

    return previousItem == itemId;
  }
}
