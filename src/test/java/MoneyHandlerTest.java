import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyHandlerTest {

    @Test
    void shouldReturnBillsAndCoinsEquivalentToGivenAmount() {
        MoneyHandler handler = new MoneyHandler(50);
        HashMap<Integer, Integer> bills = new HashMap<Integer,Integer>(){{put(50,5);put(20,2);}};
        List<Integer> expected = Arrays.asList(50,50,50,50);

        List<Integer> result = handler.handleWithdraw(bills,200);

        assertEquals(expected, result);
    }

    @Test
    void shouldInvokeNextHandlerIfAmountIsLessThanValueOfBillOrCoin(){
        HashMap<Integer, Integer> bills = new HashMap<Integer,Integer>(){{put(50,5);put(20,2);}};
        MoneyHandler handler = new MoneyHandler(50);
        handler.setNext(new MoneyHandler(20));

        List<Integer> result = handler.handleWithdraw(bills, 90);

        assertEquals(50, result.get(0));
        assertEquals(20, result.get(1));
        assertEquals(3,result.size());
    }

    @Test
    void shouldInvokeNextHandlerIfAvailableNoOfBillOrCoinIsLesserThanNeeded(){
        HashMap<Integer, Integer> bills = new HashMap<Integer,Integer>(){{put(500,1);put(200,2);put(100,6);}};
        MoneyHandler handler = new MoneyHandler(500);
        MoneyHandler handler1 = new MoneyHandler(200);
        handler.setNext(handler1);
        handler1.setNext(new MoneyHandler(100));

        List<Integer> result = handler.handleWithdraw(bills, 1200);

        assertEquals(500, result.get(0));
        assertEquals(200, result.get(1));
        assertEquals(200, result.get(2));
        assertEquals(100, result.get(3));
        assertEquals(6,result.size());

    }
}