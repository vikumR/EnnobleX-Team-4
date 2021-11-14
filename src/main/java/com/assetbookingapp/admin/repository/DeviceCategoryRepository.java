package com.assetbookingapp.admin.repository;

import com.assetbookingapp.admin.model.DeviceCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceCategoryRepository extends JpaRepository<DeviceCategory, Long> {

    @Query("SELECT d FROM DeviceCategory d WHERE d.category = ?1")
    Optional<DeviceCategory> findByCategory(String category);
}
