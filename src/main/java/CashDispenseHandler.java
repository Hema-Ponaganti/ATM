import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CashDispenseHandler {
    private final int value;
    private CashDispenseHandler next;

    public CashDispenseHandler(int value) {
        this.value = value;
    }

    public List<Integer> handleWithdraw(HashMap<Integer, Integer> bills, int amount) {
        int availableCount = bills.get(value);
        List<Integer> result = new ArrayList<>();

        if (amount >= value) {
            int count = amount / value;
            int iterator = Math.min(availableCount, count);
            for (int i = 0; i < iterator; i++) {
                result.add(value);
            }
            bills.replace(value, availableCount - iterator);
            amount = amount - (value * iterator);
        }

        if (next != null && amount > 0)
            result.addAll(next.handleWithdraw(bills, amount));

        return result;
    }

    public void setNext(CashDispenseHandler handler) {
        this.next = handler;
    }
}