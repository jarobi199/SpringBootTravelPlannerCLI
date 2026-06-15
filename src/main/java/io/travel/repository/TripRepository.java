package io.travel.repository;

import io.travel.enums.TripStatus;
import io.travel.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {
    List<Trip> findByUserId(String userId);
    List<Trip> findByUserIdAndStatusIn(String userId, List<TripStatus> statuses);
}
