package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"CityRecord\"")
@Entity
public class CityRecord extends PanacheEntityBase {
    @Id
    @ManyToOne
    @JoinColumn(name = "city_id")
    public City city;

    @Id
    @ManyToOne
    @JoinColumn(name = "year")
    public Year year;

    @Column(name="maximum_temperature",nullable = true)
    public Float maximum_temperature;

    @Column(name="minimum_temperature",nullable = true)
    public Float minimum_temperature;

    @Column(name="average_temperature",nullable = true)
    public Float average_temperature;

}
