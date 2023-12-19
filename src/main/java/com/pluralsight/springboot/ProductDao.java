package com.pluralsight.springboot;

import java.util.List;

public interface ProductDao {
    void add (Product product);
    List<Product> getAll();

}
