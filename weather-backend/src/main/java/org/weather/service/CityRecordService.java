package org.weather.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.weather.model.CityPeriodDTO;
import org.weather.model.CityRecord;
import org.weather.repository.CityRecordRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CityRecordService {
    @Inject
    CityRecordRepository cityRecordRepository;
    public List<CityPeriodDTO> getAllPeriods(Long length){
        List<CityRecord> temp=cityRecordRepository.listByYearAscending();
        ArrayList<CityPeriodDTO> res=new ArrayList<>();
        long start=temp.get(0).cityRecordId.year, end=start+length-1;
        int l=0,r=0;
        Float sum=(float)0;
        while (end<=temp.get(temp.size()-1).cityRecordId.year&&r<temp.size()){
            while (l<=r&&temp.get(l).cityRecordId.year<start){
                if (temp.get(l).average_temperature!=null) sum-=temp.get(l).average_temperature;
                l++;
            }
            while (r<temp.size()&&temp.get(r).cityRecordId.year<=end){
                if (temp.get(r).average_temperature!=null) sum+=temp.get(r).average_temperature;
                r++;
            }
            if (r>=temp.size())break;
            res.add(new CityPeriodDTO(start,length,sum/(r-l+1)));
            start++;
            end++;
        }
        return res;
    }

}
