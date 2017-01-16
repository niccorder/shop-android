package me.niccorder.shop.app.di.compontents;

import android.support.v7.app.AppCompatActivity;
import dagger.Component;
import me.niccorder.shop.app.di.module.ActivityModule;
import me.niccorder.shop.app.di.module.ItemModule;
import me.niccorder.shop.app.view.activity.MainActivity;
import me.niccorder.shop.app.view.fragment.ItemListFragment;
import me.niccorder.shop.util.di.PerActivity;

@PerActivity @Component(modules = {
    ItemModule.class, ActivityModule.class
}) public interface ItemComponent extends ActivityComponent {
  void inject(ItemListFragment itemListFragment);
}