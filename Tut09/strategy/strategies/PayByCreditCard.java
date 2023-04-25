package tuts.tut9.todo.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
    	//TO-DO: Add 'try-catch' block to catch the IO error
        try {
            //TO-DO: Ask for card number, expiration date, CVV code then save them to suitable variables
            System.out.print("Input number: ");
            String number = READER.readLine();
            System.out.print("Input date: ");
            String date = READER.readLine();
            System.out.print("Input cvv: ");
            String cvv = READER.readLine();
            //TO-DO: Create new CreditCard instance with given information
            //TO-DO: Validate credit card number...
            while (true) {
                if (number == null) {
                    System.out.print("Number cannot be null value. Pls input again: ");
                    number = READER.readLine();
                } else if (date == null) {
                    System.out.print("Date cannot be null value. Pls input again: ");
                    date = READER.readLine();
                } else {
                    System.out.print("Cvv cannot be null value. Pls input again: ");
                    cvv = READER.readLine();
                }
                card = new CreditCard(number, date, cvv);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    //TO-DO: Implement the pay() method
    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if 'cardIsPresent' => display a message 
    	to show that customer is paying with Credit Card with money amount
    	then reduce the card amount with that number
    	finally return true else return false */
        if (cardIsPresent()) {
            System.out.println("Paying by Credit Card with " + paymentAmount + "$");
            int amount = card.getAmount();
            amount -= paymentAmount;
            return true;
        }
        
        return false;
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
