package io.smartstorm.Controller;

import io.smartstorm.Entity.Weather;
import io.smartstorm.Service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/samples")
public class WeatherController {

    @Autowired
    private WeatherService weatherService = new WeatherService();

    @RequestMapping(method= RequestMethod.GET)
    public Collection<Weather> getAllWeatherSamples(){
        return weatherService.getAllWaeatherSamples();
    }

    @RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSample(@RequestBody Weather sample){
        weatherService.addSample(sample);
    }


}
