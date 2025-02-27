package io.github.nvbao.onlineshop.controller;


import io.github.nvbao.onlineshop.dto.request.product.ProductCreationRequest;
import io.github.nvbao.onlineshop.dto.request.product.ProductUpdateRequest;
import io.github.nvbao.onlineshop.entity.Product;
import io.github.nvbao.onlineshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody ProductCreationRequest request) {
        Product createdProduct = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    List<Product> searchProduct(
            @RequestParam(required = false) Long categoryId,
            @RequestParam String productName) {
        List<Product> products = productService.searchProduct(categoryId, productName);
        return products;
    }
    @GetMapping("/{productId}")
    ResponseEntity<Product> getProduct(@PathVariable String productId) {
        return productService.getProductById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{productId}")
    ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(productId, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable String productId) {
        productService.deleteProductById(productId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProductByName(@RequestParam String productName) {
        productService.deleteProductByName(productName);
    }




}
