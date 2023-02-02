import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void shouldReturnMoneyOnWithdrawal(){
        List<Integer> expected = Arrays.asList(200, 200, 20, 10, 2, 2);

        ATM atm = new ATM();
        List<Integer> currency = atm.withdraw(434);

        assertEquals(expected, currency);
    }
}