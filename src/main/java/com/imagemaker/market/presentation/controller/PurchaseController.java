package com.imagemaker.market.presentation.controller;

import com.imagemaker.market.domain.model.Purchase;
import com.imagemaker.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getPurchaseList(){
        return new ResponseEntity<>(purchaseService.getPurchaseList(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable("clientId") String clientId){
        return purchaseService.getPurchasesByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.create(purchase), HttpStatus.OK);
    }

}
