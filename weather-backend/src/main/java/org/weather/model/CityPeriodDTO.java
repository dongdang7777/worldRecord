package org.weather.model;

public class CityPeriodDTO {
    public Long start;
    public Long length;

    public Float average_temperature;

    public CityPeriodDTO(Long start, Long length, Float average_temperature){
        this.start=start;
        this.length=length;
        this.average_temperature=average_temperature;
    }
}
