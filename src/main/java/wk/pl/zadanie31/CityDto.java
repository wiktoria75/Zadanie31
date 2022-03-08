package wk.pl.zadanie31;

import lombok.Data;

import java.util.Map;

@Data
public class CityDto {

    private String name;
    private Map<String, String> local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
