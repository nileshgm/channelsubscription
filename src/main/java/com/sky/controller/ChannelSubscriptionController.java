package com.sky.controller;

import com.sky.exception.NoCustomerInformationException;
import com.sky.model.ProductCatalogue;
import com.sky.service.CatalogueService;
import com.sky.service.CustomerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChannelSubscriptionController {

    private CustomerLocationService customerLocationService;

    private CatalogueService catalogueService;

    @Autowired
    public ChannelSubscriptionController(CustomerLocationService customerLocationService, CatalogueService catalogueService) {
        this.customerLocationService = customerLocationService;
        this.catalogueService = catalogueService;
    }

    @RequestMapping(value="/customerLocationService", method= RequestMethod.GET)
    public @ResponseBody String getLocationForCustomer(@RequestParam(value = "customerId") String customerId) throws NoCustomerInformationException {

        String locationId =customerLocationService.getLocationIdForCustomer(customerId);
        if(StringUtils.isEmpty(locationId)){
            throw new NoCustomerInformationException();
        }
        return locationId;
    }


    @RequestMapping(value="/productCatalogueService", method= RequestMethod.GET)
        public @ResponseBody List<ProductCatalogue> getProductCatalogueFromLocation(@RequestParam(value="locationId") String locationId){

        Assert.notNull(locationId,"locationId should be provided");
        return catalogueService.getProductCatalogueForLocation(locationId);

    }

}
