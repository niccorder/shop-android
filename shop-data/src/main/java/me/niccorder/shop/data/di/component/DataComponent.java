package me.niccorder.shop.data.di.component;

import dagger.Component;
import dagger.Provides;
import javax.inject.Singleton;
import me.niccorder.shop.data.di.module.DataModule;
import me.niccorder.shop.data.di.module.RepositoryModule;
import me.niccorder.shop.domain.api.ItemRepository;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Provide implementers the ability to easy add this as a module to inject the datastore
 * accordingly.
 */
@Singleton @Component(modules = { RepositoryModule.class }) public interface DataComponent {
  Retrofit retrofit();
}
