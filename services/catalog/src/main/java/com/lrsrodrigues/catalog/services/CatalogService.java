package com.lrsrodrigues.catalog.services;

import com.lrsrodrigues.catalog.entities.Catalog;
import com.lrsrodrigues.catalog.repositories.CatalogRepository;
import com.lrsrodrigues.catalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    public Catalog findById(Integer id) {
        return catalogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Catalog insert(Catalog obj) {
        Catalog catalog = fromData(null, obj);
        return catalogRepository.save(catalog);
    }

    public Catalog update(Integer id, Catalog obj){
        Catalog catalog = fromData(id, obj);
        return catalogRepository.save(catalog);
    }

    public void delete(Integer id) {
        Catalog product = catalogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        catalogRepository.deleteById(product.getId());
    }

    public Catalog fromData(Integer id, Catalog obj) {
        Catalog product;

        if (id == null) {
            product = new Catalog();
        } else {
            product = catalogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        }

        product.setName(obj.getName());
        product.setPrice(obj.getPrice());

        return product;
    }
}
