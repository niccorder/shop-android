package me.niccorder.shop.app.model;


public class ViewItemModel {
  public String id;
  public String name;
  public String description;
  public float price;

  public ViewItemModel(String id, String name, String description, float price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
