package me.niccorder.shop.app.pres;

public interface MainPresenter extends Presenter {

  boolean onItemSelected(int itemId);

  int getSelectedItemId();
}
