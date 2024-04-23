package org.weather.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.weather.model.CityPeriodDTO;
import org.weather.model.CityRecord;
import org.weather.model.SumCityTemperature;
import org.weather.repository.CityRecordRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CityRecordService {
    @Inject
    CityRecordRepository cityRecordRepository;
    public List<CityPeriodDTO> getAllPeriods(Long length){
        List<SumCityTemperature> temp=cityRecordRepository.listSumCityTemperature();
        ArrayList<CityPeriodDTO> res=new ArrayList<>();
        long start=temp.get(0).year, end=start+length-1;
        int l=0,r=0;
        Long count=(long)0;
        Float sum=(float)0;
        while (end<=temp.get(temp.size()-1).year&&r<temp.size()){
            while (l<=r&&temp.get(l).year<start){
                sum-=temp.get(l).sum.floatValue();
                count-=temp.get(l).count;
                l++;
            }
            while (r<temp.size()&&temp.get(r).year<=end){
                sum+=temp.get(r).sum.floatValue();
                count+=temp.get(r).count;
                r++;
            }
            if (r>=temp.size())break;
            res.add(new CityPeriodDTO(start,length,sum/count));
            start++;
            end++;
        }
        return res;
    }

}
