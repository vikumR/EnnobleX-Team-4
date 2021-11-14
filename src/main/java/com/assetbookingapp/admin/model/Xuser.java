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
public class Xuser {

    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long userId;

    @NonNull
    private String name;

    @NonNull
    private String role;

    @NonNull
    private String employeeId;

    @NonNull
    private Boolean active;

    @NonNull
    private String userType;
}
