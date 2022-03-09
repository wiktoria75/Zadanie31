package wk.pl.zadanie31.weather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResult {

    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double visibility;
    private double windSpeed;
    private String city;

}
