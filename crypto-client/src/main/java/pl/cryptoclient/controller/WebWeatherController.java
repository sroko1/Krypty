package pl.cryptoclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cryptoclient.service.CryptoClientService;

@Controller
@RequestMapping("/weather")
@Slf4j
public class WebWeatherController {

    private final CryptoClientService cryptoClientService;

    public WebWeatherController(final CryptoClientService cryptoClientService) {
        this.cryptoClientService = cryptoClientService;
    }

    @GetMapping("/main")
    public String mainWeatherForecastView(Model model) {
        log.info("mainWeatherForecastView()");
        model.addAttribute("server_response", cryptoClientService.readWeatherForecastsAsString());
        model.addAttribute("response", cryptoClientService.readResponseFromServer());
        model.addAttribute("repos", cryptoClientService.readGithubRepos());

        return "main-page";
    }
}
