package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.weather.model.key.CountryRecordId;

@Table(name = "\"CountryRecord\"")
@Entity
public class CountryRecord extends PanacheEntityBase {
    @EmbeddedId
    public CountryRecordId countryRecordId;

    @MapsId("country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @MapsId("year")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year")
    private Year year;

    @Column(name="maximum_temperature",nullable = true)
    public Float maximum_temperature;

    @Column(name="minimum_temperature",nullable = true)
    public Float minimum_temperature;

    @Column(name="average_temperature",nullable = true)
    public Float average_temperature;

    @Column(name="population",nullable = true)
    public Integer population;



}
