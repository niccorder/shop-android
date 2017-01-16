package me.niccorder.shop.app.view;

/**
 * A Base view that all child views should extend from. All views should have some sort of network
 * error (probably will change method signature to something else in the future), as well as some
 * sort of view to show that we are loading data.
 */
public interface BaseView {

  /**
   * Create some sort of message to display to the user while we load data from any sort of
   * repository (persistent, or from network)
   */
  void showLoading(boolean show);

  /**
   * Create some sort of error to show when we cant load the requested data. God I really regret
   * naming this as 'showNetworkError'. I will be renaming this ASAP to something more generalized
   * since we can fail to load data from persistent storage as well. The view shouldn't be aware of
   * where we are loading the data from :(
   */
  void showNetworkError(boolean show);
}
