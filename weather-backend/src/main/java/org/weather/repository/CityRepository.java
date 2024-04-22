package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.City;
import org.weather.model.CityRecord;
import org.weather.model.Country;

import java.util.List;

@ApplicationScoped
public class CityRepository implements PanacheRepository<City> {

}
