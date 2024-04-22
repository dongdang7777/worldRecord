package org.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "\"Country\"")
@Entity
public class Country extends PanacheEntityBase {
    @Id
    @Column(name="id")
    public Long id;

    @Column(name="name")
    public String name;

    @Column(name="code")
    public String code;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    private Set<City> cities;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    private Set<State> states;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    private Set<CountryRecord> countryRecords;

//    Getter
    @JsonIgnore
    public Set<City> getCities() {
        return cities;
    }

    @JsonIgnore
    public Set<State> getStates() {
        return states;
    }

    @JsonIgnore
    public Set<CountryRecord> getCountryRecords() {
        return countryRecords;
    }

}
