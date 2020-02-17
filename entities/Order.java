package entities;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import entities.enums.OrderStatus;
import java.util.ArrayList;
import entities.Client;
import entities.OrderItem;
import entities.Product;


public class Order{
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  private Date moment;
  private OrderStatus status;

  private List<OrderItem> items = new ArrayList<>();
  private Client client;

  public Order(){
  }

  public Order(Date moment,OrderStatus status, Client client){
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  public OrderStatus getStatus(){
    return status;
  }

  public void setStatus(OrderStatus status){
    this.status = status;
  }

  public Client getClient(){
    return client;
  }

  public void addItem(OrderItem item){
    items.add(item);
  }

  public void removeItem(OrderItem item){
    items.remove(item);
  }

  public Double total(){
    double sum = 0.0;
    for(OrderItem x : items){
      sum += x.subTotal();
    }
    return sum ;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("ORDER SUMMARY \n");
    sb.append("Order moment: ");
    sb.append(sdf2.format(moment) + "\n");
    sb.append("Order Status: ");
    sb.append(getStatus() + "\n");
    sb.append("Client: ");
    sb.append(getClient().getName() + "(" + sdf.format(getClient().getBirthDate()) + ") "+ "- " + getClient().getEmail() + "\n");
    sb.append("Order item: \n");
    for(OrderItem x: items){
      sb.append(x + "\n");
    }
    sb.append("Total price: $");
    sb.append(total());

    return sb.toString();

  }


}