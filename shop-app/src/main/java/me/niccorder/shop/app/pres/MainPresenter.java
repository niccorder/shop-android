package me.niccorder.shop.app.pres;

import me.niccorder.shop.app.view.MenuView;

public interface MainPresenter extends Presenter<MenuView> {

  boolean onItemSelected(int itemId);

  int getSelectedItemId();
}
