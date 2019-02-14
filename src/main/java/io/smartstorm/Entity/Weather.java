package io.smartstorm.Entity;

public class Weather {

    private int id;
    private String timestamp;
    private double temperature;
    private double dew;
    private double humidity;
    private double pressure;
    private double wind;

    public Weather(int id, String timestamp, double temperature, double dew, double humidity, double pressure, double wind){
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.dew = dew;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
    }

    public Weather(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDew() {
        return dew;
    }

    public void setDew(double dew) {
        this.dew = dew;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }
}
