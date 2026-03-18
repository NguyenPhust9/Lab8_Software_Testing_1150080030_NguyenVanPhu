package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest {

    @Test(groups = {"smoke","regression"})
    public void testAddToCart() {

        System.out.println("Add product to cart");

        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void testRemoveFromCart() {

        System.out.println("Remove product from cart");

        Assert.assertTrue(true);
    }
}