import Exceptions.InvalidRequestException;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.List;

public class ATM {
    public HashMap<Integer,Integer> cassette;
    public ATM(){
        cassette = new HashMap<Integer, Integer>() {{
            put(500, 1); put(200, 2); put(100, 3); put(50, 3); put(20, 3); put(10, 3); put(5, 3); put(2, 3); put(1, 3);
        }};
    }

    private int calculateTotalMoney(){
        int total = 0;
        for (int key : cassette.keySet()) {
            total += (key * cassette.get(key));
        }
        return total;
    }
    public List<Integer> withdraw(int amount) throws Exception {
        if (amount <= 0) {
            throw new InvalidRequestException("Please enter amount in multiples of 1");
        }
        else if (this.calculateTotalMoney() < amount){
            throw new InsufficientResourcesException("The ATM machine has not enough money");
        }
        else {
            MoneyHandler handler = new HandlerChain().createChain();
            return handler.handleWithdraw(amount);
        }
    }
}