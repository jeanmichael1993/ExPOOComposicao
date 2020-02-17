  package entities;
import java.text.SimpleDateFormat;

import java.util.Date;
public class OrderItem{

  private Integer quantity;
  private Double price;

  private Product product;

  public OrderItem(){
  }

  public OrderItem(int quantity,double price, Product product){
    this.quantity = quantity;
    this.price = price;
    this.product = product;
  }

  public Integer getQuantity(){
    return quantity;
  }

  public void setQuantity(int quantity){
    this.quantity = quantity;
  }

  public Double getPrice(){
    return price;
  }

  public void setPrice(double price){
    this.price = getProduct().getPrice();
  }

  public Product getProduct(){
    return product;
  }

  public void setProduct(Product product){
    this.product = product;
  }

  public Double subTotal(){
    double valor = getPrice();
    valor = getQuantity() * valor;
    return valor;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(product.getNome());
    sb.append(", $");
    sb.append(String.format("%.2f",product.getPrice()));
    sb.append(", Quantity: ");
    sb.append(getQuantity());
    sb.append(", Subtotal: $");
    sb.append(String.format("%.2f",subTotal()));


    return sb.toString();
  }



}