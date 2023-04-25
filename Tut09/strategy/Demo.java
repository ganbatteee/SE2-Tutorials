package tuts.tut9.todo.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import tuts.tut9.todo.strategy.order.Order;
import tuts.tut9.todo.strategy.strategies.CreditCard;
import tuts.tut9.todo.strategy.strategies.PayByCreditCard;
import tuts.tut9.todo.strategy.strategies.PayByPayPal;
import tuts.tut9.todo.strategy.strategies.PayStrategy;

import javax.print.DocFlavor;

/**
 * World first console e-commerce application.
 */
public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost, totalCost;
            String continueChoice;

            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                //TO-DO: get the input value and save to new variable 'choice' (int)
                int choice = reader.read();

                //TO-DO: set the cost based on the choice
                if (choice == 1) {
                    cost = 20;
                } else if (choice == 2) {
                    cost = 30;
                } else if (choice == 3) {
                    cost = 40;
                } else if (choice == 4) {
                    cost = 50;
                }
                System.out.println("Count: ");
                int count = reader.read();
                //TO-DO: set total cost of order = cost * count
                cost = cost * count;
//                System.out.println("Total cost: " + totalCost + "$");
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                //TO-DO: get the input value and save to new variable 'paymentMethod' (String)
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                
                //TO-DO: if paymentMethod = 1 => pay by PayPal 
                //else pay by credit card
//                if (paymentMethod.equals("1")) {
//                    PayByPayPal payByPayPal = new PayByPayPal();
//                    payByPayPal.pay(totalCost);
//                } else {
//                    PayByCreditCard creditCard = new PayByCreditCard();
//                    creditCard.pay(totalCost);
//                }
                

                // Order object delegates gathering payment data to strategy
                // object, since only strategies know what data they need to
                // process a payment.
                order.processOrder(strategy);

                System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    // Finally, strategy handles the payment.
                    if (strategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    //TO-DO: close the order
                     order.setClosed();
                }
            }
        }
    }
}