package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {

}