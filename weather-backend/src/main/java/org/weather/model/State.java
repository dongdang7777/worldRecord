package org.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "\"State\"")
@Entity
public class State extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name="name")
    public String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(mappedBy = "state",fetch = FetchType.LAZY)
    private Set<StateRecord>stateRecords;

    @JsonProperty("country_id")
    @Transient
    private Long countryId;

//    Getter
    @JsonIgnore
    public Set<StateRecord> getStateRecords() {
        return stateRecords;
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
