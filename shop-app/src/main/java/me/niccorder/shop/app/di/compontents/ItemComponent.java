package me.niccorder.shop.app.di.compontents;

import dagger.Component;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.di.module.ItemModule;
import me.niccorder.shop.app.view.fragment.ItemListFragment;
import me.niccorder.shop.util.di.PerActivity;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ItemModule.class, ActivityModule.class
}) public interface ItemComponent extends ActivityComponent {
  void inject(ItemListFragment itemListFragment);
}