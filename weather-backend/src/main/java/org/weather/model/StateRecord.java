package org.weather.model;

import jakarta.persistence.*;
import net.bytebuddy.description.field.FieldDescription;

@Table(name = "\"StateRecord\"")
@Entity
public class StateRecord {
    @Id
    @ManyToOne
    @JoinColumn(name = "state_id")
    public State state;

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
