package me.niccorder.shop.app.di.compontents;

import android.app.Application;
import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import me.niccorder.shop.app.view.activity.AbstractActivity;
import me.niccorder.shop.app.di.module.ApplicationModule;
import me.niccorder.shop.app.view.activity.MainActivity;
import me.niccorder.shop.data.ShopClient;
import me.niccorder.shop.domain.executor.ExecutionThread;
import me.niccorder.shop.domain.executor.PostExecutionThread;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  Context context();
  Application applicationContext();
  ShopClient shopClient();
  ExecutionThread executionThread();
  PostExecutionThread postExecutionThread();
}
