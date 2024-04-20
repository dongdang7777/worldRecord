package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"City\"")
@Entity
public class City extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name="name")
    public String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    public Country country;

    @OneToMany(mappedBy = "city")
    Set<CityRecord> cityRecords;
}
