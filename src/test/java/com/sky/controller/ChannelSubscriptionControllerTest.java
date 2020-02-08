package com.sky.controller;

import com.sky.model.ProductCatalogue;
import com.sky.exception.NoCustomerInformationException;
import com.sky.service.CatalogueService;
import com.sky.service.CustomerLocationService;
import com.sky.stub.ProductCatalogueDbStub;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ChannelSubscriptionControllerTest {

    private CustomerLocationService mockCustomerLocationService;
    private CatalogueService mockCatalogueService;
    private ChannelSubscriptionController channelSubscriptionController;
    private Map<String, List<ProductCatalogue>> productCatalogueByLocations;

    @Before
    public void beforeEachTest(){
        mockCustomerLocationService = mock(CustomerLocationService.class);
        mockCatalogueService = mock(CatalogueService.class);
        channelSubscriptionController = new ChannelSubscriptionController(mockCustomerLocationService,mockCatalogueService);
        productCatalogueByLocations = ProductCatalogueDbStub.createAndReturnProductCatalogue();
    }

    @Test
    public void testGetLocationForCustomer_for_london_location() throws NoCustomerInformationException {
        //given
        String customerId="1001";
        String locationId = "LONDON";

        //when
        when(mockCustomerLocationService.getLocationIdForCustomer(customerId)).thenReturn(locationId);

        //then
        String expectedLocationId = channelSubscriptionController.getLocationForCustomer(customerId);
        assertNotNull(expectedLocationId);
        assertEquals(expectedLocationId,locationId);
    }

    @Test
    public void testGetLocationForCustomer_for_liverpool_location() throws NoCustomerInformationException {
        //given
        String customerId="1002";
        String locationId = "LIVERPOOL";

        //when
        when(mockCustomerLocationService.getLocationIdForCustomer(customerId)).thenReturn(locationId);

        //then
        String expectedLocationId = channelSubscriptionController.getLocationForCustomer(customerId);
        assertNotNull(expectedLocationId);
        assertEquals(expectedLocationId,locationId);
    }

    @Test(expected = NoCustomerInformationException.class)
    public void testGetLocationForCustomer_exception() throws NoCustomerInformationException {
        //given
        String customerId="1004";
        //then
        channelSubscriptionController.getLocationForCustomer(customerId);
    }

    @Test
    public void testGetProductCatalogueFromLocation_for_london(){
        //given
        String locationId = "LONDON";
        //when
        when(mockCatalogueService.getProductCatalogueForLocation(locationId)).thenReturn(productCatalogueByLocations.get(locationId));
        //then
        List<ProductCatalogue> result = channelSubscriptionController.getProductCatalogueFromLocation(locationId);
        assertNotNull(result);
        assertEquals(2, result.size());
        ProductCatalogue productCatalogue1 = result.get(0);
        assertEquals(2, productCatalogue1.getProducts().size());
    }

    @Test
    public void testGetProductCatalogueFromLocation_for_liverpool(){
        //given
        String locationId = "LIVERPOOL";
        //when
        when(mockCatalogueService.getProductCatalogueForLocation(locationId)).thenReturn(productCatalogueByLocations.get(locationId));
        //then
        List<ProductCatalogue> result = channelSubscriptionController.getProductCatalogueFromLocation(locationId);
        assertNotNull(result);
        assertEquals(2, result.size());
        ProductCatalogue productCatalogue1 = result.get(0);
        assertEquals(1, productCatalogue1.getProducts().size());
    }


    @Test
     public void testGetProductCatalogueFromLocation_for_non_existing_location(){
        //given
        String locationId = "MANCHESTER";
        //when
        when(mockCatalogueService.getProductCatalogueForLocation(locationId)).thenReturn(productCatalogueByLocations.get(locationId));
        //then
        List<ProductCatalogue> result = channelSubscriptionController.getProductCatalogueFromLocation(locationId);
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetProductCatalogueFromLocation_null_locationId(){
        List<ProductCatalogue> result = channelSubscriptionController.getProductCatalogueFromLocation(null);
    }

}
