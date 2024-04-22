package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.GlobalRecord;

@ApplicationScoped
public class GlobalRecordRepository implements PanacheRepository<GlobalRecord> {
}
