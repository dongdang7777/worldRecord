package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.State;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State> {

}
