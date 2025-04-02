package com.curse.platzi_market.web.controller;

import com.curse.platzi_market.domain.Product;
import com.curse.platzi_market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getById(@PathVariable("productId") int productId) {
        return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId).map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int productId) {
        if(productService.delete(productId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}