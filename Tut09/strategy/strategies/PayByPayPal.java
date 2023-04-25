package tuts.tut9.todo.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
    	//TO-DO: 'put' some test data (password & email) to DATA_BASE
      DATA_BASE.put("babyBear", "babybear@gmail.com");
      DATA_BASE.put("babyLion", "babyLion@gmail.com");
      DATA_BASE.put("babyRabbit", "babyRabbit@gmail.com");
      DATA_BASE.put("babyDog", "babyDog@gmail.com");
      DATA_BASE.put("babyCat", "babyCat@gmail.com");
      DATA_BASE.put("babyPig", "babyPig@gmail.com");
    }

    //TO-DO: Implement the collectPaymentDetails() method
    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
       //TO-DO: Add 'try-catch' block to catch the IO error
            while (!signedIn) {
            	//TO-DO: Ask for email & password then save them to suitable variables
                try {
                    System.out.print("Input your email: ");
                    email = READER.readLine();
                    System.out.print("Input your password: ");
                    password = READER.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            	//TO-DO: Verify the input values then display suitable message
                if (!verify()) {
                    System.out.println("Your password or email are null, pls input again");
                }
                 
            }

    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    //TO-DO: Implement the pay() method
    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if customer already 'signedIn' => display a message 
    	to show that customer is paying with PayPal with money amount
    	then return true else return false */
        if (signedIn) {
            System.out.println("Signed in successfully and pay by PayPal with " + paymentAmount + "$");
            return true;
        }
    	return false;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}