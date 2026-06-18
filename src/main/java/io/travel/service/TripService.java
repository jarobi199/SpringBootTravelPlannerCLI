package io.travel.service;

import io.travel.alert.AlertManager;
import io.travel.enums.TripStatus;
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

    public List<Trip> findAllTripsByUserId(String userId) {
        return tripRepository.findByUserId(userId);
    }

    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public List<Trip> findByUserIdAndStatusIn(String userId,  List<TripStatus> statuses) {
        if(statuses == null) {
            return tripRepository.findByUserId(userId);
        }
        return tripRepository.findByUserIdAndStatusIn(userId, statuses);
    }

    public void deleteTrip(Trip trip) {
        tripRepository.delete(trip);
    }
}
