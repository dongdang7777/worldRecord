package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.CountryRecord;
import org.weather.model.CountryRecord;
import org.weather.model.key.CountryRecordId;
import org.weather.model.key.CountryRecordId;

import java.util.List;

@ApplicationScoped
public class CountryRecordRepository implements PanacheRepository<CountryRecord> {
    public CountryRecord findById(CountryRecordId a){
        List<CountryRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CountryRecord"
                WHERE country_id=:id and year=:year
                """,CountryRecord.class).setParameter("id",a.country_id).setParameter("year",a.year).getResultList();
        if (res.size()==0)return null;
        return res.get(0);
    }

    public List<CountryRecord> findByYear(Long year){
        List<CountryRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CountryRecord"
                WHERE year=:year
                """,CountryRecord.class).setParameter("year",year).getResultList();
        return res;
    }

    public List<CountryRecord> findByCityId(Long country_id){
        List<CountryRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "CountryRecord"
                WHERE country_id=:country_id
                """,CountryRecord.class).setParameter("country_id",country_id).getResultList();
        return res;
    }

}