package org.weather.model.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StateRecordId implements Serializable {
    public Long state_id;
    public Long year;

    public StateRecordId() {
    }

    public StateRecordId(Long state_id, Long year) {
        this.state_id = state_id;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state_id, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (state_id.equals(((StateRecordId) obj).state_id) && year.equals(((StateRecordId) obj).year));
    }

}
