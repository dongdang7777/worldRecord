package org.weather.model.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryRecordId implements Serializable {
    public Long country_id;
    public Long year;

    public CountryRecordId() {
    }

    public CountryRecordId(Long country_id, Long year) {
        this.country_id = country_id;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country_id, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (country_id.equals(((CountryRecordId) obj).country_id) && year.equals(((CountryRecordId) obj).year));
    }
}
