package com.assetbookingapp.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Device {

    @Id
    @SequenceGenerator(
        name = "device_sequence",
        sequenceName = "device_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "device_sequence"
    )
    private Long id;

    @NonNull
    private String assetNumber;

    @NonNull
    private String brand;

    @NonNull
    private String model;

    @NonNull
    private String serialNumber;

    @NonNull
    private Boolean shared;

    @NonNull
    private Boolean dedicated;

    @NonNull
    private LocalDate bookedFromDate;

    @NonNull
    private LocalDate bookedToDate;

    private String version;
    private String note;
    private String modelNumber;

    private String category;
}
