package me.niccorder.shop.data.di.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.niccorder.shop.data.net.util.HeaderApplicatorInterceptor;
import me.niccorder.shop.data.net.util.SimpleRequestLogger;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A data module which will provide and create all of data-module networking repository items. This
 * can be split into submodules as necessary, but for an initial pass one module is good enough.
 */
@Module public class DataModule {

  String baseUrl;

  public DataModule(final String baseUrl) {
    super();
    this.baseUrl = baseUrl;
  }

  @Provides @Singleton OkHttpClient provideOkhttp3() {
    return new OkHttpClient.Builder().addInterceptor(new HeaderApplicatorInterceptor())
        .addInterceptor(new SimpleRequestLogger())
        .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(final OkHttpClient client) {
    return new Retrofit.Builder().baseUrl(baseUrl)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();
  }
}
