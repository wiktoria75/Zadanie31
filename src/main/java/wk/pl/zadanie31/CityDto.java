package wk.pl.zadanie31;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CityDto {

    private String name;
    @JsonProperty("local_names")
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
