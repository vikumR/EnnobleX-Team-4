package com.assetbookingapp.admin.repository;

import com.assetbookingapp.admin.model.Device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT d FROM Device d WHERE d.assetNumber = ?1")
    Optional<Device> findByAssetNumber(String assetNumber);
}
