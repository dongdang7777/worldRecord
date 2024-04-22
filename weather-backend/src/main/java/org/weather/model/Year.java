package org.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"Year\"")
@Entity
public class Year extends PanacheEntityBase {
    @Id
    @Column(name="year")
    public Long year;


    @OneToMany(mappedBy = "year",fetch = FetchType.LAZY)
    private Set<CountryRecord> countryRecords;

    @OneToMany(mappedBy = "year",fetch = FetchType.LAZY)
    private Set<CityRecord> cityRecords;

    @OneToMany(mappedBy = "year",fetch = FetchType.LAZY)
    private Set<StateRecord> stateRecords;

    @OneToOne(mappedBy = "year")
    private GlobalRecord globalRecord;

//    Getter
    @JsonIgnore
    public Set<CountryRecord> getCountryRecords() {
        return countryRecords;
    }

    @JsonIgnore
    public Set<CityRecord> getCityRecords() {
        return cityRecords;
    }

    @JsonIgnore
    public Set<StateRecord> getStateRecords() {
        return stateRecords;
    }

    @JsonIgnore
    public GlobalRecord getGlobalRecord() {
        return globalRecord;
    }
}
