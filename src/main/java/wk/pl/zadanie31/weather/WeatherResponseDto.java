package wk.pl.zadanie31.weather;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponseDto {

    private CoordDto coord;
    private List<WeatherDto> weather;
    private String base;
    private MainDto main;
    private double visibility;
    private WindDto wind;
    private CloudsDto clouds;
    private long dt;
    private SysDto sys;
    private int timezone;
    private long id;
    private String name;
    private long cod;
}
