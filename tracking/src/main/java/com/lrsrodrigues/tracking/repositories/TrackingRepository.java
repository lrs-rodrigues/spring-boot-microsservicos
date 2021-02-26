package com.lrsrodrigues.tracking.repositories;

import com.lrsrodrigues.tracking.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Integer> {

    Tracking findByUuid(UUID uuid);
    
}
