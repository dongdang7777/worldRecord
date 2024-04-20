package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.CountryRecord;

@ApplicationScoped
public class CountryRecordRepository implements PanacheRepository<CountryRecord> {

}