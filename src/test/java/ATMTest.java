import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void shouldReturnMoneyOnWithdrawal(){
        List<Integer> expected = Arrays.asList(200, 200, 20, 10, 2, 2);

        ATM atm = new ATM();
        List<Integer> result = atm.withdraw(434);

        assertEquals(expected, result);
    }

    @Test
    void  shouldNotReturnMoneyOnInvalidAmount() {
        ATM atm = new ATM();
        List<Integer> result = atm.withdraw(0);

        assertEquals(0, result.size());
    }
}