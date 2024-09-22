package com.example.product_operation.service;

import com.example.product_operation.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> getAllProducts();
    public boolean deleteProductById(Long id);
    public boolean updateProductPrice(Long id, double newPrice) throws Exception;
}
