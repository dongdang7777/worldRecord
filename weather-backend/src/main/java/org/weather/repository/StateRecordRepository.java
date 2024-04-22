package org.weather.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.weather.model.StateRecord;
import org.weather.model.StateRecord;
import org.weather.model.key.StateRecordId;
import org.weather.model.key.StateRecordId;

import java.util.List;

@ApplicationScoped
public class StateRecordRepository implements PanacheRepository<StateRecord> {
    public StateRecord findById(StateRecordId a){
        List<StateRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "StateRecord"
                WHERE state_id=:id and year=:year
                """,StateRecord.class).setParameter("id",a.state_id).setParameter("year",a.year).getResultList();
        if (res.size()==0)return null;
        return res.get(0);
    }

    public List<StateRecord> findByYear(Long year){
        List<StateRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "StateRecord"
                WHERE year=:year
                """,StateRecord.class).setParameter("year",year).getResultList();
        return res;
    }
    

    public List<StateRecord> findByCityId(Long state_id){
        List<StateRecord> res=getEntityManager().createNativeQuery("""
                SELECT * FROM "StateRecord"
                WHERE state_id=:state_id
                """,StateRecord.class).setParameter("state_id",state_id).getResultList();
        return res;

    }
}