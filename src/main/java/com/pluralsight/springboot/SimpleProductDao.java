package com.pluralsight.springboot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component @Qualifier("comp")
public class SimpleProductDao implements ProductDao {
    private List<Product> productList = new ArrayList<>();

    public SimpleProductDao() {
        Product p1 = new Product(55, "Hot Chocolate", "Beverages", 2.50);
        Product p2 = new Product(50, "Lays", "Chips", 1.50);

        productList.add(p1);
        productList.add(p2);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}
