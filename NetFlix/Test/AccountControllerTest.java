import javafx.scene.control.TextField;
import netflix.controllers.AccountController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountControllerTest {

    private AccountController controller = new AccountController();


    @Test
    void checkPasswordsWithRightInputExpectTrue() {

        boolean returnValue = controller.checkPasswords("abc", "abc");

        Assertions.assertTrue(returnValue);
    }

    @Test
    void checkPasswordsWithWrongInputExpectFalse() {

        boolean returnValue = controller.checkPasswords("abc", "xyz");

        Assertions.assertFalse(returnValue);
    }

    @Test
    void checkIntegerWithNumberInputExpectTrue() {

        boolean returnValue = controller.checkInteger(new TextField("1"));

        Assertions.assertTrue(returnValue);
    }

    @Test
    void checkIntegerWithLetterInputExpectError() {

        boolean returnValue = controller.checkInteger(new TextField("a"));

        Assertions.assertFalse(returnValue);
    }
}