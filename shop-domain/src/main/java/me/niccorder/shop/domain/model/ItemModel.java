package me.niccorder.shop.domain.model;

public class ItemModel {

  private String id;
  private String name;
  private double price;
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ItemModel)) return false;

    ItemModel itemModel = (ItemModel) o;

    if (Double.compare(itemModel.getPrice(), getPrice()) != 0) return false;
    if (!getId().equals(itemModel.getId())) return false;
    if (!getName().equals(itemModel.getName())) return false;
    return getDescription() != null ? getDescription().equals(itemModel.getDescription())
        : itemModel.getDescription() == null;
  }

  @Override public int hashCode() {
    int result;
    long temp;
    result = getId().hashCode();
    result = 31 * result + getName().hashCode();
    temp = Double.doubleToLongBits(getPrice());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "ItemModel{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", description='" + description + '\'' +
        '}';
  }
}
