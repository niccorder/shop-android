package me.niccorder.shop.app.pres;

import me.niccorder.shop.app.view.BaseView;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface Presenter<T extends BaseView> {

  void setView(T view);

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onResume() method.
   */
  void create();

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onResume() method.
   */
  void resume();

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onPause() method.
   */
  void pause();

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onDestroy() method.
   */
  void destroy();
}
