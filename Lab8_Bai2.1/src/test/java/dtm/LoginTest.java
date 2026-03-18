package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(groups = {"smoke","regression"})
    public void testLoginSuccess() {

        System.out.println("Login success test");

        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void testLoginFail() {

        System.out.println("Login fail test");

        Assert.assertTrue(true);
    }
}