package org.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "\"GlobalRecord\"")
public class GlobalRecord extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year",referencedColumnName = "year")
    private Year year;

    @Transient
    @JsonProperty("year")
    private Long yearId;

    @Column(name="maximum_temperature",nullable = true)
    public Float maximum_temperature;

    @Column(name="minimum_temperature",nullable = true)
    public Float minimum_temperature;

    @Column(name="average_temperature",nullable = true)
    public Float average_temperature;

    @Column(name="land_ocean_maximum_temperature",nullable = true)
    public Float land_ocean_maximum_temperature;

    @Column(name="land_ocean_minimum_temperature",nullable = true)
    public Float land_ocean_minimum_temperature;

    @Column(name="land_ocean_average_temperature",nullable = true)
    public Float land_ocean_average_temperature;

    //Getter
    @JsonIgnore
    public Year getYear(){
        return year;
    }

    public Long getYearId() {
        Year cur=getYear();
        if (cur==null)return null;
        return cur.year;
    }
}
