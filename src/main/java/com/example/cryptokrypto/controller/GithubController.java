package com.example.cryptokrypto.controller;

import com.example.cryptokrypto.dto.GithubRepository;
import com.example.cryptokrypto.service.GithubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repos")
    List<GithubRepository> getRepos() {
        log.info("getRepos()");

        return githubService.readGitHubRepos();
    }
}
