package wk.pl.zadanie31.weather;

import lombok.Data;

@Data
public class SysDto {

    private int type;
    private long id;
    private String country;
    private long sunrise;
    private long sunset;
}
