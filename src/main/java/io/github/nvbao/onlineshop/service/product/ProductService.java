package io.github.nvbao.onlineshop.service.product;

import io.github.nvbao.onlineshop.dto.request.product.ProductCreationRequest;
import io.github.nvbao.onlineshop.dto.request.product.ProductUpdateRequest;
import io.github.nvbao.onlineshop.entity.Category;
import io.github.nvbao.onlineshop.entity.Product;
import io.github.nvbao.onlineshop.mapper.ProductMapper;
import io.github.nvbao.onlineshop.repository.ProductRepository;
import io.github.nvbao.onlineshop.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    public Product createProduct(ProductCreationRequest request) {
        Category category = categoryService.findOrCreateCategory(request.getCategoryId());

        Product product = productMapper.toCreationProduct(request);

        product.setCategory(category);

        String newProductId = generateProductId();
        product.setProductId(newProductId);

        return productRepository.save(product);
    }
    private String generateProductId() {
        return "PRD-" + UUID.randomUUID().toString().substring(0, 8);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   public List<Product> searchProduct(Long categoryId, String productName) {
        return  productRepository.findAllByCategoryCategoryIdAndProductNameContaining(categoryId, productName);
   }
   public Product getByName(String productName) {
        return productRepository.findByProductName(productName);
   }

   public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
   }

   @Transactional
    public Optional<Product> updateProduct(String productId, ProductUpdateRequest request) {
        return getProductById(productId).map(product -> {
            product.setProductName(request.getProductName());
            product.setPrice(request.getPrice());
            product.setStockQuantity(request.getStockQuantity());

            Category category = categoryService.findOrCreateCategory(request.getCategoryId());

            product.setCategory(category);

            return productRepository.save(product);
        });
    }

    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    @Transactional
    public void deleteProductByName(String productName) {
        productRepository.deleteProductByProductName(productName);
    }

    public List<Product> filterProductsByPriceRange(BigDecimal min, BigDecimal max) {
        return productRepository.findByPriceBetween(min, max);
    }

}
