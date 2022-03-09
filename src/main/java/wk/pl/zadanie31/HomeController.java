package wk.pl.zadanie31;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wk.pl.zadanie31.weather.WeatherResult;

@Controller
public class HomeController {

    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "city", required = false) String city, Model model) {
        if (city != null) {
            WeatherResult weather = weatherService.getWeather(city);
            model.addAttribute("weather", weather);
            model.addAttribute("inputPlaceholder", weather.getCity());
        } else {
            model.addAttribute("inputPlaceholder", "ex. London");
        }
        return "home";
    }
}
