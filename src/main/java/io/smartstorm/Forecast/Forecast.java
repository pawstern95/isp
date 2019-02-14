package io.smartstorm.Forecast;

public class Forecast {

    private static Double a = 154.3793;
    private static Double b = 0.900699;
    private static Double c = -0.15097;
    private static Double d = -0.13633;
    private static Double e = 0.089188;
    private static Double f = -0.12941;

    public Double temperatureForecast(Double dewAvg, Double humAvg, Double presAvg, Double windAvg){
        return (a + b*dewAvg + c*humAvg + d*presAvg + 3*e + f*windAvg);
    }
}
