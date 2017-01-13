package me.niccorder.shop.app.di.compontents;

import dagger.Component;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.view.fragment.ItemListFragment;
import me.niccorder.shop.domain.interactor.GetItemInteractor;

@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ItemComponent extends ActivityComponent {
  void inject(ItemListFragment itemListFragment);

  void inject(GetItemInteractor getItemInteractor);
}
