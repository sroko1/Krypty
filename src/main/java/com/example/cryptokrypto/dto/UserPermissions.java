package com.example.cryptokrypto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserPermissions(
        @JsonProperty("admin") boolean isAdmin,
        @JsonProperty("maintain") boolean isMaintain) {
}
