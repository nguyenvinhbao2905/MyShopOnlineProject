package io.github.nvbao.onlineshop.dto.request.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
    String productId;
    String productName;
    String description;
    String details;
    String imageUrl;
    BigDecimal price;
    int stockQuantity;
    int soldQuantity;
    String brand;
    BigDecimal shippingFee;
    List<String> colors;
    Long categoryId;
    Long discountId;
    LocalDateTime updatedAt;
}
