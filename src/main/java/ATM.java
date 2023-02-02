import java.util.ArrayList;
import java.util.List;

public class ATM {

    private int[] bills = {500, 200, 100, 50, 20, 10};
    private int[] coins = {5, 2, 1};

    public List<Integer> withdraw(int amount) {
        List<Integer> result = new ArrayList<>();

        for (int bill : bills) {
            while (amount >= bill) {
                result.add(bill);
                amount -= bill;
            }
        }

        for (int coin : coins) {
            while (amount >= coin) {
                result.add(coin);
                amount -= coin;
            }
        }

        return result;
    }
}