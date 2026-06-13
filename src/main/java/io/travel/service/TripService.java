package io.travel.service;

import io.travel.exception.EntityNotFoundException;
import io.travel.model.Trip;
import io.travel.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip findTripById(String id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found: " + id));
    }

    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }

}
