package me.niccorder.shop.data;

import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;
import me.niccorder.shop.data.api.ItemService;
import me.niccorder.shop.data.net.SimpleRequestLogger;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ShopClient {

  final ConcurrentHashMap<Class, Object> services;
  final Retrofit retrofit;

  public ShopClient(Application application) {
    this.services = new ConcurrentHashMap<>();
    this.retrofit = buildRetrofit(provideOkhttpClient());
  }

  private OkHttpClient provideOkhttpClient() {
    return new OkHttpClient.Builder().addInterceptor(new SimpleRequestLogger()).build();
  }

  private Retrofit buildRetrofit(final OkHttpClient client) {
    return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .validateEagerly(true)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create())
        .build();
  }

  public ItemService getItemService() {
    return getService(ItemService.class);
  }

  @SuppressWarnings("unchecked") protected <T> T getService(Class<T> klazz) {
    if (!services.contains(klazz)) {
      services.putIfAbsent(klazz, retrofit.create(klazz));
    }
    return (T) services.get(klazz);
  }
}
