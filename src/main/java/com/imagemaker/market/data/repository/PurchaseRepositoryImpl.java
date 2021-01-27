package com.imagemaker.market.data.repository;

import com.imagemaker.market.data.crud.PurchaseCrudRepository;
import com.imagemaker.market.data.entity.DataPurchase;
import com.imagemaker.market.data.mapper.PurchaseMapper;
import com.imagemaker.market.domain.model.Purchase;
import com.imagemaker.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getPurchaseList() {
        List<DataPurchase> purchases = (List<DataPurchase>) purchaseCrudRepository.findAll();
        return mapper.fromDataToDomain(purchases);
    }

    @Override
    public Optional<List<Purchase>> getPurchasesByClient(String clientId) {

        return purchaseCrudRepository.findByCustomerId(clientId)
                .map(dataPurchases -> mapper.fromDataToDomain(dataPurchases));
    }

    @Override
    public Purchase create(Purchase purchase) {
        DataPurchase dataPurchase = mapper.fromDomainToData(purchase);
        dataPurchase.getProducts().forEach(product -> product.setPurchase(dataPurchase));
        return mapper.fromDataToDomain(purchaseCrudRepository.save(dataPurchase));
    }
}
