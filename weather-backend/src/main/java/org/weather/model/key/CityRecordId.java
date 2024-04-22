package org.weather.model.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CityRecordId implements Serializable {
    public Long city_id;
    public Long year;

    public CityRecordId() {
    }

    public CityRecordId(Long cityId, Long year) {
        this.city_id = cityId;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (city_id.equals(((CityRecordId) obj).city_id) && year.equals(((CityRecordId) obj).year));
    }

}
