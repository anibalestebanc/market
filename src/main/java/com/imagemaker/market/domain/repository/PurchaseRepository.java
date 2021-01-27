package com.imagemaker.market.domain.repository;

import com.imagemaker.market.domain.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getPurchaseList();
    Optional<List<Purchase>> getPurchasesByClient(String clientId);
    Purchase create(Purchase purchase);
}
