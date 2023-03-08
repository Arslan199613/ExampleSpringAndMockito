package com.example.workwithspringandmockito.controllers;

import com.example.workwithspringandmockito.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String teamNAme) {
        return teamService.add(teamNAme);
    }

    @GetMapping("/find")
    public String find(@RequestParam String teamName) {
        return teamService.find(teamName);

    }
    @GetMapping("/remove")
    public String remove(@RequestParam String teamName) {
        return teamService.remove(teamName);
    }

    @GetMapping("/all")
    public Collection<String> findTeam(String prefix) {
        if (prefix != null) {
            return teamService.findTeamsByPrefix(prefix);
        }
        return teamService.findTeams();
    }

    @GetMapping("/all/format")
    public String findTeamsAsString() {
        return teamService.findTeamsAsString();
    }
}
