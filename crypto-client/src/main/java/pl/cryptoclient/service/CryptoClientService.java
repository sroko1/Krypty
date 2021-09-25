package pl.cryptoclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.cryptoclient.dto.ServerResponseDto;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CryptoClientService {

    private final RestTemplate restTemplate;
    private final String url;
    private final String reposUrl;

    public CryptoClientService(final RestTemplate restTemplate,
                               @Value("${connection.weather.url}") final String url,
                               @Value("${connection.github.url}") final String reposUrl) {
        this.reposUrl = reposUrl;
        log.info("connection url: [{}]", url);
        log.info("github connection url: [{}]", reposUrl);
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String readWeatherForecastsAsString() {
        String result = "";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        log.info("response: [{}]", response);
        if (response.getStatusCode().is2xxSuccessful()) {
            result = response.getBody();
        }

        return result;
    }

    public List<ServerResponseDto> readResponseFromServer() {
        ServerResponseDto[] resultArray = restTemplate.getForObject(url, ServerResponseDto[].class);
        List<ServerResponseDto> result = Arrays.asList(resultArray);
        log.info("response from server: {}", result);
        return result;
    }

    public String readGithubRepos() {
        String result = restTemplate.getForObject(reposUrl, String.class);
        log.info("repos: [{}]", result);

        return result;
    }
}
