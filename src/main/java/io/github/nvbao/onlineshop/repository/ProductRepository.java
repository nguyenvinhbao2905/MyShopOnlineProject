package io.github.nvbao.onlineshop.repository;


import io.github.nvbao.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByCategoryCategoryIdAndProductNameContaining(Long categoryId, String productName);
    Product findByProductName(String productName);
    void deleteProductByProductName(String productName);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByCategory_CategoryId(Long categoryId);


    Optional<Product> findTopByOrderByCreatedAtDesc();

    List<Product> findTop10ByOrderBySoldQuantityDesc();


    boolean existsByProductName(String productName);

    List<Product> findByBrand(String brand);
}
