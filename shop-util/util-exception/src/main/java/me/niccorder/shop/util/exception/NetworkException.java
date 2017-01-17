package me.niccorder.shop.util.exception;

import java.io.IOException;

/**
 * Exception to be thrown when there is a problem with the network.
 */
public class NetworkException extends IOException {
  public NetworkException(String s) {
    super(s);
  }
}
