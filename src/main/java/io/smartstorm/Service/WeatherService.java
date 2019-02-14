package io.smartstorm.Service;

import io.smartstorm.Dao.WeatherDao;
import io.smartstorm.Entity.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    public Collection<Weather> getAllWaeatherSamples(){
        return weatherDao.getAllWaeatherSamples();
    }

    public void addSample(Weather sample){
        this.weatherDao.addSample(sample);
    }
}
