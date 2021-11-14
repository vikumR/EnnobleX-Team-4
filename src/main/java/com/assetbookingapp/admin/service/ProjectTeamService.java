package com.assetbookingapp.admin.service;

import com.assetbookingapp.admin.model.ProjectTeam;
import com.assetbookingapp.admin.repository.ProjectTeamRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectTeamService {

    private final ProjectTeamRepository projectTeamRepository;

    public List<ProjectTeam> getTeams() {
        return projectTeamRepository.findAll();
    }

    public void addTeam(ProjectTeam projectTeam) {
        Optional<ProjectTeam> teamByTeamName = projectTeamRepository.findByTeamName(projectTeam.getTeamName());

        if (teamByTeamName.isPresent()) {
            throw new IllegalStateException("Project Team already exists");
        }

        projectTeamRepository.save(projectTeam);
    }
}
