package com.lrsrodrigues.address.config;

import com.lrsrodrigues.address.entities.Address;
import com.lrsrodrigues.address.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Locale;

@Configurable
@Profile("dev")
public class TestConfigs implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);

        Address address1 = new Address(null, "Rua das Rosas", "168", "Casa 2", "Vila Rosa", "89756555", "Brazil", "USER", 1);
        Address address2 = new Address(null,  "Rua das Flores", "488", null, "Praça das Flores", "56385222", "Brazil", "USER", 2);
        Address address3 = new Address(null, "Rua das Tulipas", "655", "Predio 1", "Vila Roxinol", "12345888", "Brazil", "USER", 3);

        addressRepository.saveAll(Arrays.asList(address1, address2, address3));
    }
}
