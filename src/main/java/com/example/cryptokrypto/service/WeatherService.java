package com.example.cryptokrypto.service;

import com.example.cryptokrypto.dto.WeatherDto;
import com.example.cryptokrypto.entity.Weather;
import com.example.cryptokrypto.mapper.WeatherMapper;
import com.example.cryptokrypto.repository.WeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WeatherService {

//    @Slf4j = the same as code below
//    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    final private WeatherRepository weatherRepository;
    final private WeatherMapper mapper;

    public WeatherService(final WeatherRepository weatherRepository,
                          final WeatherMapper mapper) {
        this.weatherRepository = weatherRepository;
        this.mapper = mapper;
    }

    // CRUD
    public List<WeatherDto> getAllWeathers() {
        var objectsFromRepo = weatherRepository.findAll();
        log.info("weathers from repo: {}", objectsFromRepo);

        return objectsFromRepo
                .stream() // Stream<Weather>
                .map(weather -> mapper.fromEntityToDto(weather)) // Stream<WeatherDto>
                .collect(Collectors.toList());
    }

    public Optional<WeatherDto> findWeatherById(Long id) {
        var result = weatherRepository.findById(id)
                .map(weather -> mapper.fromEntityToDto(weather));

        log.info("trying to find object by id: [{}], result: [{}]", id, result);
        return result;
    }

    public WeatherDto createNewWeatherForecast(WeatherDto newWeather) {
        Weather entityToSave = mapper.fromDtoToEntity(newWeather);
        Weather saved = weatherRepository.save(entityToSave);
        log.info("creating entity [{}] from provided dto [{}]", saved, newWeather);

        return mapper.fromEntityToDto(saved);
    }

    @Transactional
    public boolean deleteWeatherById(Long id) {
        log.info("deleting weather by id: [{}]", id);

        if (weatherRepository.existsById(id)) {
            weatherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
