package org.acme.services;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleService {

    @ConfigProperty(name = "greeting.message")
    String message;

    public String hello(String name) {
        return message + " " + name;
    }
}
