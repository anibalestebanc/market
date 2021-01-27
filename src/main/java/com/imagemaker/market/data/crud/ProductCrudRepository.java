package com.imagemaker.market.data.crud;

import com.imagemaker.market.data.entity.DataProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<DataProduct, Integer>{

    List<DataProduct> findByCategoryIdOrderByNameAsc(int idCategory);
}
