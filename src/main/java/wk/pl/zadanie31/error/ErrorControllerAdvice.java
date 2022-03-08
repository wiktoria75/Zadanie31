package wk.pl.zadanie31.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(WeatherDataNotAvailableException.class)
    public String handleException(Model model) {
        model.addAttribute("error", "City not found. Enter city name in English and with capital letter.");
        return "home";
    }
}