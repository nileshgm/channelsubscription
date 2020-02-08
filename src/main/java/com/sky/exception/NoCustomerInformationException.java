package com.sky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="There was a problem retrieving the customer information")
public class NoCustomerInformationException extends  Exception{
}
