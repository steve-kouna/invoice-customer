/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.customer.api;

import com.koona.invoise.core.entity.customer.Customer;
import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.core.service.InvoiceServiceInterface;
import com.koona.invoise.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Steve KOUNA
 */
@RestController
@RequestMapping("/customer")
public class CustomerResource {
    
    @Autowired
    private CustomerRepositoryInterface customerRepositoryInterface;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long number) {
        return customerRepositoryInterface.findById(number).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public CustomerRepositoryInterface getCustomerRepositoryInterface() {
        return customerRepositoryInterface;
    }

    public void setCustomerRepositoryInterface(CustomerRepositoryInterface customerRepositoryInterface) {
        this.customerRepositoryInterface = customerRepositoryInterface;
    }
}
