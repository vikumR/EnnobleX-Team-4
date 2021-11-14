package com.assetbookingapp.admin.controller;

import com.assetbookingapp.admin.model.ProjectTeam;
import com.assetbookingapp.admin.service.ProjectTeamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/teams")
@AllArgsConstructor
public class ProjectTeamController {

    private final ProjectTeamService teamService;

    @GetMapping
    public List<ProjectTeam> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public void createNewTeam(@RequestBody ProjectTeam projectTeam) {
        teamService.addTeam(projectTeam);
    }

}
