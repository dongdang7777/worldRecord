package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"Country\"")
@Entity
public class Country extends PanacheEntityBase {
    @Id
    @Column(name="id")
    public Integer id;

    @Column(name="name")
    public String name;

    @Column(name="code")
    public String code;

    @OneToMany(mappedBy = "country")
    public Set<City> cities ;

    @OneToMany(mappedBy = "country")
    public Set<State> states;

    @OneToMany(mappedBy = "country")
    public Set<CountryRecord> countryRecords;


}
