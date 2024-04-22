package org.weather.model;

import jakarta.persistence.*;
import org.weather.model.key.StateRecordId;

@Table(name = "\"StateRecord\"")
@Entity
public class StateRecord {
    @EmbeddedId
    public StateRecordId stateRecordId;

    @MapsId("state_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;

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
