package com.example.cryptokrypto.service;

import com.example.cryptokrypto.dto.GithubRepository;
import com.example.cryptokrypto.dto.GithubRepositoryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GithubService implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final String githubUrl;

    public GithubService(RestTemplate restTemplate,
                         @Value("${github.repository.url}") String githubUrl) {
        this.restTemplate = restTemplate;
        this.githubUrl = githubUrl;

        log.info("github url: [{}]", githubUrl);
    }

    public List<GithubRepository> readGitHubRepos() {
        var responseFromServer = restTemplate.getForObject(githubUrl, GithubRepository[].class);
        var result = Arrays.asList(responseFromServer);
        log.info("result: {}", result);

        return result;
    }

    // TODO: fix
    public List<GithubRepository> readGitHubReposV2() {
        GithubRepositoryWrapper responseFromServer = restTemplate.getForObject(githubUrl, GithubRepositoryWrapper.class);

        var result = responseFromServer.repositoryList();

        log.info("result v2: {}", result);
        return result;
    }

    // TODO:
    public List<GithubRepository> readGitHubReposV3() {
        var responseFromServer = restTemplate.exchange(githubUrl, HttpMethod.GET, null,
                ParameterizedTypeReference.forType(GithubRepository[].class));
        return Collections.emptyList();
    }

        @Override
    public void run(String... args) throws Exception {
        readGitHubRepos();
//        readGitHubReposV2();
    }
}
