package com.example.product_operation.controller;

import com.example.product_operation.entity.Product;
import com.example.product_operation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/get")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        boolean productByid = productService.deleteProductById(id);
        if(productByid == true){
            return "Product deleted Successfully !";
        }else {
            return "Not Deleted";
        }
    }

    @PutMapping("/{id}")
    public String updateProductPrice(@PathVariable Long id, double newPrice) throws Exception {
        boolean deleteProduct = productService.updateProductPrice(id,newPrice);
        return "Product added Successfully !";
    }

}
