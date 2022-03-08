package wk.pl.zadanie31.weather;

import lombok.Data;

@Data
public class WeatherDto {

    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private double visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private long cod;
}
