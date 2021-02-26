package com.lrsrodrigues.tracking.services;

import com.lrsrodrigues.tracking.entities.Tracking;
import com.lrsrodrigues.tracking.repositories.TrackingRepository;
import com.lrsrodrigues.tracking.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    public List<Tracking> findAll() {
        return trackingRepository.findAll();
    }

    public Tracking findById(Integer id) {
        return trackingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Tracking findByUuid(UUID uuid) {
        return trackingRepository.findByUuid(uuid);
    }
}
