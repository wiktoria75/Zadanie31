package wk.pl.zadanie31;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wk.pl.zadanie31.city.CityDto;
import wk.pl.zadanie31.error.WeatherDataNotAvailableException;
import wk.pl.zadanie31.weather.WeatherDto;
import wk.pl.zadanie31.weather.WeatherResult;

@Service
public class WeatherService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final double KELVIN_TO_CELCIUS = -272.15;

    public WeatherResult getWeather(String name) {
        String weatherUrl = getWeatherUrl(name);
        try {
            WeatherDto weather = restTemplate.getForObject(weatherUrl, WeatherDto.class);
            if (weather.getName().startsWith(name)) {
                return toWeatherResult(weather, name);
            } else {
                throw new WeatherDataNotAvailableException();
            }
        } catch (Exception e) {
            throw new WeatherDataNotAvailableException();
        }
    }

    private String getWeatherUrl(String name) {
        String cityUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + name +
                "&limit=1&appid=ed9e933754414fd27117f41869a3b90d";
        try {
            CityDto[] cities = restTemplate.getForObject(cityUrl, CityDto[].class);
            CityDto city = cities[0];
            double lat = city.getLat();
            double lon = city.getLon();
            return "http://api.openweathermap.org/data/2.5/weather?lat=" +
                    lat + "&lon=" + lon +
                    "&appid=ed9e933754414fd27117f41869a3b90d";
        } catch (Exception e) {
            throw new WeatherDataNotAvailableException();
        }
    }

    private WeatherResult toWeatherResult(WeatherDto weatherDto, String name) {
        return WeatherResult.builder()
                .temp(String.format("%.2f", weatherDto.getMain().getTemp() + KELVIN_TO_CELCIUS))
                .feels_like(String.format("%.2f", weatherDto.getMain().getFeels_like() + KELVIN_TO_CELCIUS))
                .temp_max(String.format("%.2f", weatherDto.getMain().getTemp_max() + KELVIN_TO_CELCIUS))
                .temp_min(String.format("%.2f", weatherDto.getMain().getTemp_min() + KELVIN_TO_CELCIUS))
                .pressure(weatherDto.getMain().getPressure())
                .humidity(weatherDto.getMain().getHumidity())
                .visibility(weatherDto.getVisibility())
                .windSpeed(weatherDto.getWind().getSpeed())
                .city(name)
                .build();
    }
}
