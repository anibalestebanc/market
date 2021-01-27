package com.imagemaker.market.data.mapper;

import com.imagemaker.market.data.entity.DataProduct;
import com.imagemaker.market.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({
            @Mapping(target = "productId", source = "dataProduct.productId"),
            @Mapping(target = "name", source = "dataProduct.name"),
            @Mapping(target = "categoryId", source = "dataProduct.categoryId"),
            @Mapping(target = "price", source = "dataProduct.salePrice"),
            @Mapping(target = "stock", source = "dataProduct.stock"),
            @Mapping(target = "active", source = "dataProduct.state"),
            @Mapping(target = "category", source = "dataProduct.category"),
    })
    Product fromDataToDomainProduct(DataProduct dataProduct);
    List<Product> toDomain(List<DataProduct> dataProducts);


    @Mappings({
            @Mapping(target = "productId", source = "product.productId"),
            @Mapping(target = "name", source = "product.name"),
            @Mapping(target = "categoryId", source = "product.categoryId"),
            @Mapping(target = "salePrice", source = "product.price"),
            @Mapping(target = "stock", source = "product.stock"),
            @Mapping(target = "state", source = "product.active"),
            @Mapping(target = "category", source = "product.category")
    })
    DataProduct fromDomainToDataProduct(Product product);

}
