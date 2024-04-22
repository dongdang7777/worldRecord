package org.weather.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.weather.model.key.CityRecordId;

@Table(name = "\"CityRecord\"")
@Entity
public class CityRecord extends PanacheEntityBase {
    @EmbeddedId
    public CityRecordId cityRecordId;

    @MapsId("city_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

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




}
