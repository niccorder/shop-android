package me.niccorder.shop.util.exception;

/**
 * Thrown when we have sent a bad request.
 */
public class BadRequestException extends NetworkException {
  public BadRequestException(String s) {
    super(s);
  }
}
