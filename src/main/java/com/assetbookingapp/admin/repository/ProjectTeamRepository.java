package com.assetbookingapp.admin.repository;

import com.assetbookingapp.admin.model.ProjectTeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, Long> {

    @Query("SELECT t FROM ProjectTeam t WHERE t.teamName = ?1")
    Optional<ProjectTeam> findByTeamName(String teamName);
}
