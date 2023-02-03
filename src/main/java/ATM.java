import Exceptions.InvalidRequestException;

import java.util.List;

public class ATM {
    public List<Integer> withdraw(int amount) throws Exception {
        if (amount <= 0) {
            throw new InvalidRequestException("Please enter amount in multiples of 1");
        } else {
            MoneyHandler handler = new HandlerChain().createChain();
            return handler.handleWithdraw(amount);
        }
    }
}