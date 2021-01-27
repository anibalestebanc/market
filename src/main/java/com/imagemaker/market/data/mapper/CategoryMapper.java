package com.imagemaker.market.data.mapper;


import com.imagemaker.market.data.entity.DataCategory;
import com.imagemaker.market.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "categoryId", source = "category.categoryId"),
            @Mapping(target = "category", source = "category.description"),
            @Mapping(target = "active", source = "category.state")
    })
    Category fromDataToDomainCategory(DataCategory category);

    @Mappings({
            @Mapping(target = "categoryId", source = "category.categoryId"),
            @Mapping(target = "description", source = "category.category"),
            @Mapping(target = "state", source = "category.active")
    })
    DataCategory fromDomainToDataCategory(Category category);

}
