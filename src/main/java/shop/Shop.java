package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;

    private List<Product> products;

    Shop(String name) {
        //TODO
        this.name=name;
        products = new ArrayList<>();

    }

    String getName() {
        return name;
    }

    List<Product> getProducts() {
        return products;
    }

    public void addNewProduct(Product product) {
        //TODO implement method
        products.add(product);

    }

    public void removeProductFromShelf(String name) {
        //TODO implement method
    }

   // public List<Product> inventory() {
     //   //TODO implement method

    //}

    public void getCheapProducts() {
        //TODO implement method
    }
}
