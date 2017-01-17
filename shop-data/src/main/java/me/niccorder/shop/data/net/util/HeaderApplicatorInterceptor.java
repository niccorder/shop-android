package me.niccorder.shop.data.net.util;

import android.os.Build;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class HeaderApplicatorInterceptor implements Interceptor {

  private static final Headers REQUEST_HEADERS = Headers.of("User-Agent", buildUserAgent());

  private static String buildUserAgent() {
    return String.format("Android/%s/%s/%s (%s; %s; %s;)", Build.VERSION.SDK_INT,
        Build.VERSION.CODENAME, Locale.getDefault(), Build.DEVICE, Build.PRODUCT,
        Build.MANUFACTURER);
  }

  @Override public Response intercept(Chain chain) throws IOException {
    return chain.proceed(chain.request().newBuilder().headers(REQUEST_HEADERS).build());
  }
}
