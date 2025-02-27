package io.github.nvbao.onlineshop.repository;

import io.github.nvbao.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductInventoryRepository extends JpaRepository<Product, Long> {
}
