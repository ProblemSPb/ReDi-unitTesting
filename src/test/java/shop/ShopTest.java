package shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {

    @Test
    void addingNewProduct_updatesTheListOfProducts() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);

        shop.addNewProduct(biscuits);

        // this one is from AssertJ Fluent Assertions
        Assertions.assertThat(shop.getProducts().size()).isEqualTo(1);

        // this one is from JUnit
        assertEquals(1, shop.getProducts().size());
        assertEquals(biscuits, shop.getProducts().get(0));
    }


    @Test
    void addingMultipleProducts_updatesTheListOfProducts() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);

        shop.addNewProduct(biscuits);
        shop.addNewProduct(coffee);

        Assertions.assertThat(shop.getProducts().size()).isEqualTo(2);

        assertEquals(2, shop.getProducts().size());
        assertEquals(Arrays.asList(biscuits, coffee), shop.getProducts());
    }


    @Test
    void removingProductFromShelf_removesItemFromList() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(coffee);

        shop.removeProductFromShelf(biscuits.getName());

        Assertions.assertThat(shop.getProducts().size()).isEqualTo(1);

        assertEquals(1, shop.getProducts().size());
        assertEquals(coffee, shop.getProducts().get(0));
    }


    @Test
    void removingProductFromShelf_removesJustOneItem_WhenMultipleItemsWithTheSameNameAreInTheShop() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product moreBiscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(moreBiscuits);
        shop.addNewProduct(coffee);

        shop.removeProductFromShelf(biscuits.getName());

        Assertions.assertThat(shop.getProducts().size()).isEqualTo(2);

        assertEquals(2, shop.getProducts().size());
        assertEquals(Arrays.asList(moreBiscuits, coffee), shop.getProducts());
    }

    @Test
    void doingTheInventory_returnsAllItemsFromTheShop() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product milk = new Product("milk", 1);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(milk);
        shop.addNewProduct(coffee);

        List<Product> inventory = shop.inventory();

        Assertions.assertThat(inventory.size()).isEqualTo(3);

        assertEquals(3, inventory.size());
        assertEquals(Arrays.asList(biscuits, milk, coffee), shop.getProducts());
    }

    @Test
    void gettingCheapProducts_returnsAllItemsWithPriceLowerOrEqualTo2Eur() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product milk = new Product("milk", 1);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(milk);
        shop.addNewProduct(coffee);

        List<Product> cheapProducts = shop.getCheapProducts();

        Assertions.assertThat(cheapProducts.size()).isEqualTo(2);

        assertEquals(2, cheapProducts.size());

        // returns all products with price less than 2 euro
    }
}
