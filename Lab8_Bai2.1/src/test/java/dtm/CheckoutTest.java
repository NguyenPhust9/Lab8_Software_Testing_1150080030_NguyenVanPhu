package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest {

    @Test(groups = {"smoke","regression"})
    public void testCheckoutSuccess() {

        System.out.println("Checkout success");

        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void testCheckoutCancel() {

        System.out.println("Checkout cancel");

        Assert.assertTrue(true);
    }
}