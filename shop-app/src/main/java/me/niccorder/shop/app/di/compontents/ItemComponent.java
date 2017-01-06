package me.niccorder.shop.app.di.compontents;

import dagger.Component;
import me.niccorder.shop.app.di.PerActivity;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.di.module.ItemModule;
import me.niccorder.shop.app.view.fragment.ItemListFragment;

/**
 * Item
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, ItemModule.class
}) public interface ItemComponent extends ActivityComponent {
  void inject(ItemListFragment itemListFragment);
}
