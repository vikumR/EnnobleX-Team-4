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
public class DeviceCategory {

    @Id
    @SequenceGenerator(
        name = "device_type_sequence",
        sequenceName = "device_type_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "device_type_sequence"
    )
    private Long id;

    @NonNull
    private String category;

    private String deviceNote;
}
