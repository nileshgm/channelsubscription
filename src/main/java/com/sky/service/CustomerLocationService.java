package com.sky.service;

import org.springframework.stereotype.Service;

public interface CustomerLocationService {

    String getLocationIdForCustomer(String customerId);
}
