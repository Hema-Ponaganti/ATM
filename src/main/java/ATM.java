import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ATM {
    private final List<Bill> bills;
    private final List<Coin> coins;

    public ATM(){
        this.bills = Arrays.asList(new Bill(500), new Bill(200), new Bill(100), new Bill(50), new Bill(20), new Bill(10));
        this.coins = Arrays.asList(new Coin(5), new Coin(2), new Coin(1));
    }

    public List<Integer> withdraw(int amount) {
        List<Integer> result = new ArrayList<>();

        for (Bill bill : bills) {
            while (amount >= bill.getValue()) {
                result.add(bill.getValue());
                amount -= bill.getValue();
            }
        }

        for (Coin coin : coins) {
            while (amount >= coin.getValue()) {
                result.add(coin.getValue());
                amount -= coin.getValue();
            }
        }

        return result;
    }
}