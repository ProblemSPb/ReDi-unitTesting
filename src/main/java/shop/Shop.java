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

    String getName() { return name; }

    List<Product> getProducts() { return products; }

    public void addNewProduct(Product product) {
        //TODO implement method
        products.add(product);

    }

    public void removeProductFromShelf(String name) {
        //TODO implement method

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                products.remove(i);
                break;  // i remove just one if identified
            }
        }

    }

   public List<Product> inventory() {
        //TODO implement method
        return products;
    }

    public List<Product> getCheapProducts() {
        //TODO implement method

         List<Product> cheapProduct = new ArrayList<Product>();

        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getPrice() <= 2) {
                cheapProduct.add(currentProduct);
            }
        }
        return cheapProduct;
    }

}
