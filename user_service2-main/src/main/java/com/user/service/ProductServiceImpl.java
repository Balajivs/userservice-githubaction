package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.user.entity.Product;
import com.user.repository.ProductRepository;

@Service(value="productService")
public class ProductServiceImpl implements  ProductService{


    @Autowired
    @Qualifier(value="productRepository")
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductbyId(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductbyId(Integer id) {

        productRepository.deleteById(id);
    }
}
