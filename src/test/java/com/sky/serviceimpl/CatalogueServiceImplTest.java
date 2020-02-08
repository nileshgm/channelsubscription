package com.sky.serviceimpl;

import com.sky.model.ProductCatalogue;
import com.sky.service.CatalogueService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueServiceImplTest {


    private CatalogueService catalogueService;

    @Before
    public void beforeEachTest(){
        catalogueService = new CatalogueServiceImpl();
    }

    @Test
    public void testGetProductCatalogueForLocation_with_london_locationId(){
        String locationId = "LONDON";
        List<ProductCatalogue> result = catalogueService.getProductCatalogueForLocation(locationId);
        assertNotNull(result);
        assertEquals(2,result.size());
    }

    @Test
    public void testGetProductCatalogueForLocation_with_liverpool_locationId(){
        String locationId = "LIVERPOOL";
        List<ProductCatalogue> result = catalogueService.getProductCatalogueForLocation(locationId);
        assertNotNull(result);
        assertEquals(2,result.size());
    }

    @Test
    public void testGetProductCatalogueForLocation_unknown_locationId(){
        String locationId = "MANCHESTER";
        List<ProductCatalogue> result = catalogueService.getProductCatalogueForLocation(locationId);
        assertNull(result);
    }

    @Test
    public void testGetProductCatalogueForLocation_null_location(){
        List<ProductCatalogue> result = catalogueService.getProductCatalogueForLocation(null);
        assertNull(result);
    }


}
