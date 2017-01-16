package me.niccorder.shop.app.pres.impl;

import javax.inject.Inject;
import me.niccorder.shop.app.pres.MainPresenter;
import me.niccorder.shop.app.view.MenuView;
import timber.log.Timber;

/**
 * The presenter that handles the base activity functions.
 */
public class MainPresenterImpl implements MainPresenter {

  /** The view that our presenter will be interacting with */
  private MenuView mMenuView;

  /** The currently selected item id */
  private int mCurrentItemId;

  @Inject public MainPresenterImpl() {
  }

  @Override public void setView(MenuView view) {
    this.mMenuView = view;
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
