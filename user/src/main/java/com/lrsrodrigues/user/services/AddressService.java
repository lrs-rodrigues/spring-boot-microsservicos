package com.lrsrodrigues.user.services;

import com.lrsrodrigues.user.dto.AddressDTO;
import com.lrsrodrigues.user.entities.Address;
import com.lrsrodrigues.user.entities.User;
import com.lrsrodrigues.user.repositories.AddressRepository;
import com.lrsrodrigues.user.repositories.UserRepository;
import com.lrsrodrigues.user.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address insert(AddressDTO address) {
        Address obj = fromData(null, address);
        return addressRepository.save(obj);
    }

    public Address update(Integer id, AddressDTO address) {
        Address obj = fromData(id, address);
        return addressRepository.save(obj);
    }

    public void delete(Integer id) {
        Address obj = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        addressRepository.deleteById(obj.getId());
    }

    public Address fromData(Integer id, AddressDTO obj) {
        Address address;
        User user = userRepository.findById(obj.getUserId()).orElseThrow(() -> new ResourceNotFoundException(id));

        if (id == null) {
            address = new Address();
        } else {
            address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        }

        address.setAddress(obj.getAddress());
        address.setStreet(obj.getStreet());
        address.setCity(obj.getCity());
        address.setState(obj.getState());
        address.setZipcode(obj.getZipcode());
        address.setCountry(obj.getCountry());
        address.setUser(user);

        return address;
    }

}