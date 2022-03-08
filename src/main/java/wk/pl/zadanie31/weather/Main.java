package wk.pl.zadanie31.weather;

import lombok.Data;

@Data
public class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
    private double sea_level;
    private double grnd_level;
}
