package com.imagemaker.market.domain.service;

import com.imagemaker.market.domain.model.Purchase;
import com.imagemaker.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;


    public List<Purchase> getPurchaseList(){
       return purchaseRepository.getPurchaseList();
    }

    public Optional<List<Purchase>> getPurchasesByClient(String clientId){
        return purchaseRepository.getPurchasesByClient(clientId);
    }

    public Purchase create(Purchase purchase){
        return purchaseRepository.create(purchase);
    }
}
