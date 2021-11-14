package com.assetbookingapp.admin.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table
public class ProjectTeam {

    @Id
    @SequenceGenerator(
        name = "team_sequence",
        sequenceName = "team_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "team_sequence"
    )
    private Long id;

    @NonNull
    private String teamName;

    @NonNull
    private String leadName;
}
