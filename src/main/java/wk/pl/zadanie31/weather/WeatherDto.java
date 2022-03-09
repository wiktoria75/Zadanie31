package wk.pl.zadanie31.weather;

import lombok.Data;

@Data
public class WeatherDto {
    private long id;
    private String main;
    private String description;
    private String icon;
}
