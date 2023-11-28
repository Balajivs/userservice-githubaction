package com.user.service;

import java.util.List;

import com.user.entity.Product;

public interface ProductService {

    Product addProduct(Product product);

    Product getProductbyId(Integer id);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    void deleteProductbyId(Integer id);


}
