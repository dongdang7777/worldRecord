package org.weather.model;

public class SumCityTemperature {
       public Long year;
       public Double sum;
       public Long count;
       SumCityTemperature(Long year, Double sum,Long count){
              this.year=year;
              this.sum=sum;
              this.count=count;
       }
}
