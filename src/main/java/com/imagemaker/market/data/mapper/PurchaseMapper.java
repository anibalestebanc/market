package com.imagemaker.market.data.mapper;

import com.imagemaker.market.data.entity.DataPurchase;
import com.imagemaker.market.domain.model.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {


    @Mappings({
            @Mapping(target = "purchaseId", source = "purchaseId"),
            @Mapping(target = "clientId", source = "customerId"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "paymentMethod", source = "paymentType"),
            @Mapping(target = "comment", source = "comment"),
            @Mapping(target = "state", source = "state"),
            @Mapping(target = "items", source = "products")
    })
    Purchase fromDataToDomain(DataPurchase purchase);

    List<Purchase> fromDataToDomain(List<DataPurchase> dataPurchases);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    DataPurchase fromDomainToData(Purchase purchase);

}
