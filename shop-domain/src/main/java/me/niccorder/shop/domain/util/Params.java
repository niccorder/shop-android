package me.niccorder.shop.domain.util;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public class Params {

  public static Params NONE = Params.create();

  private final Map<String, Object> parameters;

  private Params() {
    this.parameters = new HashMap<>();
  }

  public static Params create() {
    return new Params();
  }

  public <T> void put(final String key, T value) {
    parameters.put(key, value);
  }

  public <T> T getAs(final String key, final Class<T> klass) {
    return klass.cast(parameters.get(key));
  }

  public int getInt(final String key) {
    return (int) parameters.get(key);
  }

  public double getDouble(final String key) {
    return (double) parameters.get(key);
  }

  public String getString(final String key) {
    return parameters.get(key).toString();
  }
}
