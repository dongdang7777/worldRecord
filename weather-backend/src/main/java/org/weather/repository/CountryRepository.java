package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.Country;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<Country> {

}
