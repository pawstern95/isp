package io.smartstorm.Dao;

import io.smartstorm.Entity.Weather;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDao {

    private static Map<Integer, Weather> weatherSamples;

    static {

        weatherSamples = new HashMap<Integer, Weather>(){
            {
                put(1, new Weather(1, "1200", 20.00, 21.00, 80.00, 1012, 0));
                put(2, new Weather(2, "1205", 20.00, 21.00, 87.00, 1015, 0));
                put(3, new Weather(3, "1210", 20.00, 21.00, 82.00, 1020, 0));
            }
        };
    }

    public Collection<Weather> getAllWaeatherSamples(){
        return this.weatherSamples.values();
    }

    public void addSample(Weather sample){
        this.weatherSamples.put(sample.getId(), sample);
    }

    public Weather getSample(int id){

        return this.weatherSamples.get(id);
    }

    public Double getAverageTemperature(){
        Double sum=0.0;
        Integer counter=0;
        for (io.smartstorm.Entity.Weather sample : this.weatherSamples.values()){
            sum += sample.getTemperature();
            counter++;
        }
        return sum/counter;
    }

    public Double getAverageHumidity(){
        Double sum=0.0;
        Integer counter=0;
        for (io.smartstorm.Entity.Weather sample : this.weatherSamples.values()){
            sum += sample.getHumidity();
            counter++;
        }
        return sum/counter;
    }

    public Double getAverageDew(){
        Double sum=0.0;
        Integer counter=0;
        for (io.smartstorm.Entity.Weather sample : this.weatherSamples.values()){
            sum += sample.getDew();
            counter++;
        }
        return sum/counter;
    }

    public Double getAveragePressure(){
        Double sum=0.0;
        Integer counter=0;
        for (io.smartstorm.Entity.Weather sample : this.weatherSamples.values()){
            sum += sample.getPressure();
            counter++;
        }
        return sum/counter;
    }

    public Double getAverageWind(){
        Double sum=0.0;
        Integer counter=0;
        for (io.smartstorm.Entity.Weather sample : this.weatherSamples.values()){
            sum += sample.getWind();
            counter++;
        }
        return sum/counter;
    }


}
