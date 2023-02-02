import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyHandlerTest {

    @Test
    void shouldReturnBillsAndCoinsEquivalentToGivenAmount() {
        MoneyHandler handler = new MoneyHandler(50);
        List<Integer> expected = Arrays.asList(50,50,50,50);

        List<Integer> result = handler.handleWithdraw(200);

        assertEquals(expected, result);
    }

    @Test
    void shouldInvokeNextHandlerIfAmountIsLessThanValue(){
        MoneyHandler handler = new MoneyHandler(50);
        handler.setNext(new MoneyHandler(20));

        List<Integer> result = handler.handleWithdraw(40);

        assertEquals(20, result.get(0));
        assertEquals(20, result.get(1));
    }

    @Test
    void shouldNotReturnBillsOrCoinsIfAmountIsLesserThanValue(){
        MoneyHandler handler = new MoneyHandler(50);

        List<Integer> result = handler.handleWithdraw(40);

        assertEquals(0, result.size());
    }
}