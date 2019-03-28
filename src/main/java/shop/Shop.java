package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private String name;

    private List<Product> products;

    Shop(String name) {
        //TODO
    }

    String getName() {
        return name;
    }

    List<Product> getProducts() {
        return products;
    }

    public void addNewProduct(Product product) {
        //TODO implement method
    }

    public void removeProductFromShelf(String name) {
        //TODO implement method
    }

    public List<Product> inventory() {
        //TODO implement method
    }

    public List<Product> getCheapProducts() {
        //TODO implement method
    }
}
