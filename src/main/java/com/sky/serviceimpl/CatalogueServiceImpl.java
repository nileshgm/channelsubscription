package com.sky.serviceimpl;

import com.sky.model.ProductCatalogue;
import com.sky.service.CatalogueService;
import com.sky.stub.ProductCatalogueDbStub;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    Map<String, List<ProductCatalogue>> productCatalogueByLocations = new HashMap<>();

    public CatalogueServiceImpl(){
        productCatalogueByLocations = ProductCatalogueDbStub.createAndReturnProductCatalogue();
    }
    @Override
    public List<ProductCatalogue> getProductCatalogueForLocation(String locationId) {
        return productCatalogueByLocations.get(locationId);
    }
}
