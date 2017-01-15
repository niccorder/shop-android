package me.niccorder.shop.app.di.compontents;

import android.app.Application;
import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import me.niccorder.shop.app.di.module.ApplicationModule;
import me.niccorder.shop.data.di.module.RepositoryModule;
import me.niccorder.shop.domain.api.ItemRepository;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;

@Singleton @Component(modules = { ApplicationModule.class, RepositoryModule.class })
public interface ApplicationComponent {

  Context context();

  Application applicationContext();

  ExecutionThread executionThread();

  PostExecutionThread postExecutionThread();

  ItemRepository itemRepository();
}
