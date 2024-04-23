package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.weather.model.SumCityTemperature;
import org.weather.model.CityPeriodDTO;
import org.weather.model.CityRecord;
import org.weather.model.key.CityRecordId;
import org.weather.service.CityRecordService;

import java.util.List;

@ApplicationScoped
public class CityRecordRepository implements PanacheRepository<CityRecord>{
    @Inject
    CityRecordService cityRecordService;

    public CityRecord findById(CityRecordId a){
        List<CityRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CityRecord"
                WHERE city_id=:id and year=:year
                """,CityRecord.class).setParameter("id",a.city_id).setParameter("year",a.year).getResultList();
        if (res.size()==0)return null;
        return res.get(0);
    }

    public List<CityRecord> findByYear(Long year){
        List<CityRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CityRecord"
                WHERE year=:year
                """,CityRecord.class).setParameter("year",year).getResultList();
        return res;
    }

    public List<CityRecord> findByCityId(Long city_id){
        List<CityRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CityRecord"
                WHERE city_id=:city_id
                """,CityRecord.class).setParameter("city_id",city_id).getResultList();
        return res;

    }

    public CityPeriodDTO getPeriodByCityId(long id,long start, long length){
        Double res=(Double)getEntityManager().createNativeQuery("""
                   SELECT avg(average_temperature) from "CityRecord" 
                   where city_id=:id and year between :start and :start + :length - 1 and average_temperature is not null 
                   group by city_id
                """).setParameter("id",id).setParameter("start",start ).setParameter("length",length).getSingleResult();
        return new CityPeriodDTO(start,length,res.floatValue());
    }

    public List<CityRecord> listByYearAscending(){
        List<CityRecord> temp= getEntityManager().createNativeQuery("""
                SELECT * FROM "CityRecord" 
                ORDER BY Year;
                """,CityRecord.class).getResultList();
        return temp;
    }


    public List<SumCityTemperature> listSumCityTemperature(){
            return getEntityManager().createNativeQuery("""
                            with cnt as (
                            	select year,average_temperature from "CityRecord"
                            	where average_temperature is not null
                            )
                            select year,sum(average_temperature) as sum,count(*) as count from cnt
                            group by year
                            order by year
                      """
            ,SumCityTemperature.class).getResultList();
    }


}
