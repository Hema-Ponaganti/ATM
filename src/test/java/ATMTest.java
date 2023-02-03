import Exceptions.InvalidRequestException;
import org.junit.jupiter.api.Test;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ATMTest {
    @Test
    void shouldReturnMoneyOnWithdrawal() throws Exception {
        List<Integer> expected = Arrays.asList(200, 200, 20, 10, 2, 2);
        ATM atm = new ATM();

        List<Integer> result = atm.withdraw(434);

        assertEquals(expected, result);
    }

    @Test
    void shouldThrowInvalidRequestExceptionOnEnteringInvalidAmount() {
        ATM atm = new ATM();

        assertThrows(InvalidRequestException.class, () -> atm.withdraw(0));
    }

    @Test
    void shouldThrowExceptionWhenATMHasNotEnoughMoney() {
        ATM atm = new ATM();

        assertThrows(InsufficientResourcesException.class, () -> atm.withdraw(5000));
    }
}