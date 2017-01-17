package me.niccorder.shop.util.exception;

/**
 * Thrown we we do not have a network connection.
 */
public class NoNetworkException extends NetworkException {
  public NoNetworkException(String s) {
    super(s);
  }
}
