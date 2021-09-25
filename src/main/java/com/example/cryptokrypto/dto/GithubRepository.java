package com.example.cryptokrypto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubRepository(
        @JsonProperty("full_name") String repoName,
        RepoOwner owner,
        @JsonProperty("forks_url") String forksUrl) {
}
