package io.smartstorm.WebSocket;

import io.smartstorm.Entity.Weather;
import io.smartstorm.Forecast.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import io.smartstorm.Dao.WeatherDao;

import java.util.Collection;
import java.util.Date;


@Controller
public class SocketController {

    @Autowired
    private WeatherDao weatherDao;
    public Collection<Weather> getAllWaeatherSamples(){
        return weatherDao.getAllWaeatherSamples();
    }
    private double weatherForecast=0.0;

    private Forecast forecast = new Forecast();
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        weatherForecast = forecast.temperatureForecast(weatherDao.getAverageDew(), weatherDao.getAverageHumidity(), weatherDao.getAveragePressure(), weatherDao.getAverageWind());
        weatherForecast *= 100;
        weatherForecast = Math.round(weatherForecast);
        weatherForecast /= 100;
        java.util.Date date = new java.util.Date();
        java.util.Date currentDate = date;
        date = null;
        return new Greeting(currentDate + ": Temperature: " + weatherForecast);


    }
}
