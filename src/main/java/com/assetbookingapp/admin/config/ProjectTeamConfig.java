package com.assetbookingapp.admin.config;

import com.assetbookingapp.admin.model.ProjectTeam;
import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.repository.ProjectTeamRepository;
import com.assetbookingapp.admin.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProjectTeamConfig {

    @Bean
    CommandLineRunner commandLineRunnerForTeam(ProjectTeamRepository teamRepository) {
        return args -> {
            ProjectTeam team = new ProjectTeam(
                "testTeam",
                "testTeamLead");

            ProjectTeam team1 = new ProjectTeam(
                "testTeam1",
                "testTeamLead1");

            teamRepository.saveAll(Arrays.asList(team, team1));
        };
    }
}
