package com.example.product_operation.service.impl;

import com.example.product_operation.entity.Product;
import com.example.product_operation.repository.ProductRepository;
import com.example.product_operation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateProductPrice(Long id, double newPrice) throws Exception {
        Optional<Product > optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(newPrice);
            productRepository.save(product);
            return true;
        }else{
            throw new Exception("Product is Not persent");
        }
    }


}
