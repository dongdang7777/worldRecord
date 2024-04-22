package org.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"City\"")
@Entity
public class City extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name="name")
    public String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city")
    private Set<CityRecord> cityRecords;

    @JsonProperty("country_id")
    @Transient
    private Long countryId;


//    Getter
    @JsonIgnore
    public Set<CityRecord> getCityRecords() {
        return cityRecords;
    }

    @JsonIgnore
    public Country getCountry() {
        return country;
    }


    public Long getCountryId(){
        Country cur=getCountry();
        if (cur!=null)return cur.id;
        return null;
    }

}
