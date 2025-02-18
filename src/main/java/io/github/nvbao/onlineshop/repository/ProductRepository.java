package io.github.nvbao.onlineshop.repository;


import io.github.nvbao.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByCategoryContainingOrNameProductContaining(String category, String nameProduct);
    Product findByNameProduct(String nameProduct);
    Product findProductById(long id);
}
