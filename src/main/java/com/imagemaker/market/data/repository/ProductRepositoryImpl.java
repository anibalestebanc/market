package com.imagemaker.market.data.repository;

import com.imagemaker.market.data.crud.ProductCrudRepository;
import com.imagemaker.market.data.entity.DataProduct;
import com.imagemaker.market.data.mapper.ProductMapper;
import com.imagemaker.market.domain.model.Product;
import com.imagemaker.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductCrudRepository crudRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getAll() {
        List<DataProduct> productList = (List<DataProduct>) crudRepository.findAll();
        return productMapper.toDomain(productList);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<DataProduct> productList = crudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toDomain(productList));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<DataProduct> dataProducts = crudRepository.findById(productId);
        return dataProducts.map(dataProduct -> productMapper.fromDataToDomainProduct(dataProduct));
    }

    @Override
    public Product save(Product product) {
        DataProduct dataProduct = crudRepository.save(productMapper.fromDomainToDataProduct(product));
        return productMapper.fromDataToDomainProduct(dataProduct);
    }

    @Override
    public void delete(int productId) {
        crudRepository.deleteById(productId);
    }
}
