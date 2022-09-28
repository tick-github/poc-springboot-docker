package com.tick.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String emailAddress)
{}