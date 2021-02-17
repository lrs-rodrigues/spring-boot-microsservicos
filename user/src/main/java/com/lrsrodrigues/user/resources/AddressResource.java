package com.lrsrodrigues.user.resources;

import com.lrsrodrigues.user.dto.AddressDTO;
import com.lrsrodrigues.user.entities.Address;
import com.lrsrodrigues.user.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1/address")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@RequestParam(value = "id", required = true) Integer id) {
        Address address = addressService.findById(id);
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Address> insert(@RequestBody AddressDTO addressDTORequest) {
        Address address = addressService.insert(addressDTORequest);
        return ResponseEntity.created(uri(address.getId())).body(address);
    }

    @PutMapping(value = "/{address.id}")
    public ResponseEntity<Address> update(@RequestParam("address.id") Integer id, @RequestBody AddressDTO addressDTORequest) {
        Address address = addressService.update(id, addressDTORequest);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping(value = "/{address.id}")
    public ResponseEntity<Void> delete(@RequestParam("address.id") Integer id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI uri(Integer id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return uri;
    }

}