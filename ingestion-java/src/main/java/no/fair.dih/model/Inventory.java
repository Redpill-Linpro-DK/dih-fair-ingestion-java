package no.fair.dih.model;

public class Inventory {
  private String sku;
  private int quantity;
  private Uom uom;

  public enum Uom {
    KG,
    BOXES
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Uom getUom() {
    return uom;
  }

  public void setUom(Uom uom) {
    this.uom = uom;
  }
}
