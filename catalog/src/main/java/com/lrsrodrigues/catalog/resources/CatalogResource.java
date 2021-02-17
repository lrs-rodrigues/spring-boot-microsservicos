package com.lrsrodrigues.catalog.resources;

import com.lrsrodrigues.catalog.entities.Catalog;
import com.lrsrodrigues.catalog.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/catalog")
public class CatalogResource {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public ResponseEntity<List<Catalog>> findAll() {
        List<Catalog> catalog  = catalogService.findAll();
        return ResponseEntity.ok().body(catalog);
    }

    @GetMapping(value = "/{catalog.id}")
    public ResponseEntity<Catalog> findById(@PathVariable("catalog.id") Integer id) {
        Catalog catalog = catalogService.findById(id);
        return ResponseEntity.ok().body(catalog);
    }

    @PostMapping
    public ResponseEntity<Catalog> insert(@RequestBody Catalog obj) {
        Catalog catalog = catalogService.insert(obj);
        return ResponseEntity.created(uri(catalog.getId())).body(catalog);
    }

    @PutMapping(value = "/{catalog.id}")
    public ResponseEntity<Catalog> update(@PathVariable("catalog.id") Integer id, @RequestBody Catalog obj) {
        Catalog catalog = catalogService.update(id, obj);
        return ResponseEntity.ok().body(catalog);
    }

    @DeleteMapping(value = "/{catalog.id}")
    public ResponseEntity<Void> delete(@PathVariable("catalog.id") Integer id) {
        catalogService.delete(id);
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