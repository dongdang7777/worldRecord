package org.weather.model;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;


@Table(name = "\"CountryRecord\"")
@Entity
public class CountryRecord extends PanacheEntityBase {
    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country country;

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

    @Column(name="population",nullable = true)
    public Integer population;



}
