package com.imagemaker.market.data.mapper;

import com.imagemaker.market.data.entity.DataPurchasesProduct;
import com.imagemaker.market.domain.model.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(target = "productId", source = "item.id.productId"),
            @Mapping(target = "quantity", source = "item.quantity"),
            @Mapping(target = "total", source = "item.total"),
            @Mapping(target = "active", source = "item.state")

    })
    PurchaseItem fromDataToDomain(DataPurchasesProduct item);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "item.purchaseId", ignore = true)
    })
    DataPurchasesProduct fromDomainToData(PurchaseItem item);
}
