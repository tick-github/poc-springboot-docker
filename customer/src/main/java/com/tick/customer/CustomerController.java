package com.tick.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest customerRegistrationRequest) {

        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping("/all")
    public List<CustomerResponse> getAllCustomers() {

        log.info("new request for all customers");
        return customerService.getAllCustomers();
    }
}