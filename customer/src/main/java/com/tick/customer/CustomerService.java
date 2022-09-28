package com.tick.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .emailAddress(request.emailAddress())
                .build();

        customerRepository.save(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> response = new ArrayList<>();

        customers.forEach(
                customer ->
                        response.add(
                                CustomerResponse.builder()
                                        .firstName(customer.getFirstName())
                                        .lastName(customer.getLastName())
                                        .emailAddress(customer.getEmailAddress())
                                        .build()
                        )
        );

        return response;
    }
}