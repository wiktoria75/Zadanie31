package wk.pl.zadanie31;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wk.pl.zadanie31.weather.WeatherResult;

@Controller
public class HomeController {

    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String search(@RequestParam("name") String name, Model model) {
        WeatherResult weather = weatherService.getWeather(name);
        model.addAttribute("weather", weather);
        return "home";
    }
}
