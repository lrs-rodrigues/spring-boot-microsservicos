package com.lrsrodrigues.catalog.repositories;

import com.lrsrodrigues.catalog.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
}
