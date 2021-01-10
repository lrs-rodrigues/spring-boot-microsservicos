package com.lrsrodrigues.address.services;

import com.lrsrodrigues.address.dto.AddressDTO;
import com.lrsrodrigues.address.entities.Address;
import com.lrsrodrigues.address.repositories.AddressRepository;
import com.lrsrodrigues.address.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address findByOwnerId(Integer ownerId) {
        return addressRepository.findByOwnerId(ownerId);
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
        address.setOwnerType(obj.getOwnerType());
        address.setOwnerId(obj.getOwnerId());

        return address;
    }

}