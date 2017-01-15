package me.niccorder.shop.data.di.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.niccorder.shop.data.net.ItemApiService;
import me.niccorder.shop.domain.api.ItemRepository;
import retrofit2.Retrofit;

@Module(includes = DataModule.class) public class RepositoryModule {

  @Provides @Singleton ItemRepository provideItemRepository(final Retrofit retrofit) {
    return new ItemApiService(retrofit);
  }
}
