import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Main{

  public static void main(String [] args) throws ParseException{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
   

    System.out.println("Enter cliente data: ");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.next();
    System.out.print("Birth date (DD/MM/YYYY): ");
    Date date = sdf.parse(sc.next()); 

    Client client = new Client(name, email, date);

    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    OrderStatus status = OrderStatus.valueOf(sc.next());

     Order order = new Order(new Date(), status, client);

    System.out.print("How many items to this order? ");
    int n = sc.nextInt();

    for(int i=0;i<n;i++){
      System.out.printf("Enter #%d item data: %n",i+1);
      sc.nextLine();
      System.out.print("Product name: ");
      String nameProd = sc.nextLine();
      System.out.print("Product price: ");
      double priceProd = sc.nextDouble();

      Product product = new Product(nameProd, priceProd);

      System.out.print("Quantity: ");
      int quantity = sc.nextInt();

      OrderItem item = new OrderItem(quantity, priceProd, product);
      order.addItem(item);
    }

    System.out.println();
    System.out.println(order);

  sc.close();
  }

}