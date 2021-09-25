package pl.cryptoclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServerResponseDto(Long id,
                                @JsonProperty("moje_miasto") String myCity,
                                @JsonProperty("temp_in_cs") Long tempInCelsius) {
}
