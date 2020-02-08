package com.sky.service;

import com.sky.model.ProductCatalogue;

import java.util.List;

public interface CatalogueService {

    List<ProductCatalogue> getProductCatalogueForLocation(String locationId);
}
