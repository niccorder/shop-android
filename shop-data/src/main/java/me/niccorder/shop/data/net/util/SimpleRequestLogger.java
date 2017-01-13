package me.niccorder.shop.data.net.util;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import timber.log.Timber;


/** logs out a basic "METHOD   /path/to/endpoint" */
public class SimpleRequestLogger implements Interceptor {
  @Override public Response intercept(Chain chain) throws IOException {
    Timber.d("%s %s", chain.request().method(), chain.request().url());

    return chain.proceed(chain.request());
  }
}
