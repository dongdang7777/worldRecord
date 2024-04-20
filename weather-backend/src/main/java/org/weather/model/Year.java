package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"Year\"")
@Entity
public class Year extends PanacheEntityBase {
    @Id
    @Column(name="year")
    public Integer year;

    @OneToMany(mappedBy = "year")
    public Set<CountryRecord> countryRecords;

    @OneToMany(mappedBy = "year")
    public Set<CityRecord> cityRecords;

    @OneToMany(mappedBy = "year")
    public Set<StateRecord> stateRecords;
}
