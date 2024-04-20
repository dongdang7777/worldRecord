package org.weather.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.Year;

@ApplicationScoped
public class YearRepository implements PanacheRepository<Year> {

}
