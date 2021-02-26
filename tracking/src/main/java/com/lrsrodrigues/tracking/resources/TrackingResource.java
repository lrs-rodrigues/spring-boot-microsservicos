package com.lrsrodrigues.tracking.resources;

import com.lrsrodrigues.tracking.entities.Tracking;
import com.lrsrodrigues.tracking.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/tracking")
public class TrackingResource {

    @Autowired
    private TrackingService trackingService;

    @GetMapping
    public ResponseEntity<List<Tracking>> findAll() {
        List<Tracking> trackingList = trackingService.findAll();
        return ResponseEntity.ok().body(trackingList);
    }

    @GetMapping(value = "/{tracking.id}")
    public ResponseEntity<Tracking> findById(@PathVariable("tracking.id") Integer id) {
        Tracking tracking = trackingService.findById(id);
        return ResponseEntity.ok().body(tracking);
    }

    @GetMapping(value = "/get-tracking-uuid/{tracking.uuid}")
    public ResponseEntity<Tracking> findByUuid(@PathVariable("tracking.uuid") UUID uuid) {
        Tracking tracking = trackingService.findByUuid(uuid);
        return ResponseEntity.ok().body(tracking);
    }
}
