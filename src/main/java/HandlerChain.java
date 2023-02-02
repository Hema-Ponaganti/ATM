import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandlerChain {

    public MoneyHandler createChain() {
        List<Bill> bills = Arrays.asList(new Bill(500), new Bill(200), new Bill(100), new Bill(50), new Bill(20), new Bill(10));
        List<Coin> coins = Arrays.asList(new Coin(5), new Coin(2), new Coin(1));

        List<MoneyHandler> handlers = Stream.concat(
                bills.stream().map(b -> new MoneyHandler(b.getValue())),
                coins.stream().map(c -> new MoneyHandler(c.getValue()))
        ).collect(Collectors.toList());
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        return handlers.get(0);
    }
}
