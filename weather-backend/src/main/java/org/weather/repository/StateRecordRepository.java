package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.StateRecord;

@ApplicationScoped
public class StateRecordRepository implements PanacheRepository<StateRecord> {
}
