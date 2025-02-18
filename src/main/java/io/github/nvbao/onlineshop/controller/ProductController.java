package io.github.nvbao.onlineshop.controller;


import io.github.nvbao.onlineshop.dto.request.ProductCreationRequest;
import io.github.nvbao.onlineshop.dto.request.ProductUpdateRequest;
import io.github.nvbao.onlineshop.entity.Product;
import io.github.nvbao.onlineshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    Product createProduct(@RequestBody ProductCreationRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String nameProduct) {
        List<Product> products = productService.searchProduct(category, nameProduct);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{productId}")
    Product getProduct(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable Long productId, @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(productId, request);
    }

}
