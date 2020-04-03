package netflix.test;

import netflix.app.Helper;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void testPercentageCalculation() {
        double total = 200;
        double amount = 10;
        double expected_percentage = 5;

        double result = Helper.getPercentage(amount, total);

        assertEquals(result, expected_percentage, "Math does not work");
    }

    @Test
    void testInvertedPercentageCalculation() {
        double percentage = 5;
        double total = 200;
        double expected_amount = 10;

        double result = Helper.getPartFromPercentage(percentage, total);

        assertEquals(result, expected_amount, "Math does not work");
    }

    
}