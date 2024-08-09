package com.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Product;
import com.user.service.ProductService;

@RestController
@Scope(value = "request")
public class ProductsController {


    @Autowired
  //  @Qualifier(value="productService")
    ProductService productService;

    @PostMapping(value="/saveProduct", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code= HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping(value = "/getProductbyId/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product getProductById(@PathVariable("id") Integer id){
        return productService.getProductbyId(id);
    }

    @PutMapping(value="/updateProduct",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code=HttpStatus.OK)
    Product updateProduct(@RequestBody Product product){
     return productService.updateProduct(product);
    }


    @DeleteMapping(value="/productdeletebyId/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void  productdeletebyId(@PathVariable("id") Integer id){
        productService.deleteProductbyId(id);

    }
    
    
    
    @PostMapping(value="/addProduct",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Product aaddProduct(@RequestBody Product product) {
    	
    	return productService.addProduct(product);
    }
    
    @GetMapping(value="/getAllProduct",produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProduct(){
    	
    	return productService.getAllProduct();
    }
   
   
}
