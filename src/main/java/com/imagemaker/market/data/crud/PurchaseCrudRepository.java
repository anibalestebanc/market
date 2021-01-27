package com.imagemaker.market.data.crud;

import com.imagemaker.market.data.entity.DataPurchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<DataPurchase, Integer> {

    Optional<List<DataPurchase>> findByCustomerId(String clientId);

}
