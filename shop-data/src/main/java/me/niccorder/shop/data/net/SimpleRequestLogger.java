package me.niccorder.shop.data.net;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by nic on 1/5/17.
 */

public class SimpleRequestLogger implements Interceptor {
  @Override public Response intercept(Chain chain) throws IOException {
    Timber.d("%s %s", chain.request().method(), chain.request().url());

    return chain.proceed(chain.request());
  }
}
