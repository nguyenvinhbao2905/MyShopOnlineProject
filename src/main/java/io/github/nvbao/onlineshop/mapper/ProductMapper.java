package io.github.nvbao.onlineshop.mapper;


import io.github.nvbao.onlineshop.dto.request.product.ProductCreationRequest;
import io.github.nvbao.onlineshop.dto.request.product.ProductUpdateRequest;
import io.github.nvbao.onlineshop.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toCreationProduct(ProductCreationRequest request);
    Product toUpdateProduct(ProductUpdateRequest request);
}
