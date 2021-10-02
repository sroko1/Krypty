package com.example.cryptokrypto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepoLicense(
        String key,
        @JsonProperty("spdx_id") String spdxId
) {
}
