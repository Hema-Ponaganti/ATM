
import java.util.ArrayList;
import java.util.List;

public class MoneyHandler {
    private final int value;
    private MoneyHandler next;

    public MoneyHandler(int value) {
        this.value = value;
    }

    public List<Integer> handleWithdraw(int amount) {
        List<Integer> result = new ArrayList<>();
        if (amount >= value) {
            int count = amount / value;
            for (int i = 0; i < count; i++) {
                result.add(value);
            }
        }
        if (next != null && amount > 0)
            result.addAll(next.handleWithdraw(amount % value));
        return result;
    }

    public void setNext(MoneyHandler handler) {
        this.next = handler;
    }
}
