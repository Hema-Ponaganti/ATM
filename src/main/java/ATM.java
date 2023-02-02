
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ATM {

    public List<Integer> withdraw(int amount) {
        MoneyHandler handler = new HandlerChain().createChain();
        return handler.handleWithdraw(amount);
    }


}