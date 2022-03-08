package wk.pl.zadanie31.weather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResult {

    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private double pressure;
    private double humidity;
    private double visibility;
    private double windSpeed;
    private String city;

}
