package wk.pl.zadanie31;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wk.pl.zadanie31.error.WeatherDataNotAvailableException;
import wk.pl.zadanie31.weather.WeatherResponseDto;
import wk.pl.zadanie31.weather.WeatherResult;

@Service
public class WeatherService {

    private static final RestTemplate restTemplate = new RestTemplate();

    public WeatherResult getWeather(String name) {
        String weatherUrl = getWeatherUrl(name);
        try {
            WeatherResponseDto weather = restTemplate.getForObject(weatherUrl, WeatherResponseDto.class);
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
                    "&appid=ed9e933754414fd27117f41869a3b90d&units=metric";
        } catch (Exception e) {
            throw new WeatherDataNotAvailableException();
        }
    }

    private WeatherResult toWeatherResult(WeatherResponseDto weatherDto, String name) {
        return WeatherResult.builder()
                .temp(weatherDto.getMain().getTemp())
                .feelsLike(weatherDto.getMain().getFeelsLike())
                .tempMax(weatherDto.getMain().getTempMax())
                .tempMin(weatherDto.getMain().getTempMin())
                .pressure(weatherDto.getMain().getPressure())
                .humidity(weatherDto.getMain().getHumidity())
                .visibility(weatherDto.getVisibility())
                .windSpeed(weatherDto.getWind().getSpeed())
                .city(name)
                .build();
    }
}
