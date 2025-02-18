package io.github.nvbao.onlineshop.service;

import io.github.nvbao.onlineshop.dto.request.ProductCreationRequest;
import io.github.nvbao.onlineshop.dto.request.ProductUpdateRequest;
import io.github.nvbao.onlineshop.entity.Product;
import io.github.nvbao.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    

    public Product createProduct(ProductCreationRequest request) {
        Product product = new Product();
        product.setNameProduct(request.getNameProduct());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());

        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   public List<Product> searchProduct(String category, String nameProduct) {
        return  productRepository.findAllByCategoryContainingOrNameProductContaining(category, nameProduct);
   }
   public Product getByName(String name) {
        return productRepository.findByNameProduct(name);
   }

   public Product getProductById(Long id) {
        return productRepository.findProductById(id);
   }
   public Product updateProduct(Long id, ProductUpdateRequest request) {
        Product product = getProductById(id);

        product.setNameProduct(request.getNameProduct());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());

        return productRepository.save(product);
   }
}
