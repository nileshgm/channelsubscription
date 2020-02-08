package com.sky.stub;

import com.sky.service.CustomerLocationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerLocationServiceStub implements CustomerLocationService {

    private Map<String,String> locationsForCustomers = new HashMap<>();

    public CustomerLocationServiceStub() {
        locationsForCustomers.put("1001","LONDON");
        locationsForCustomers.put("1002","LIVERPOOL");
    }

    @Override
    public String getLocationIdForCustomer(String customerId) {
        return locationsForCustomers.get(customerId);
    }
}
