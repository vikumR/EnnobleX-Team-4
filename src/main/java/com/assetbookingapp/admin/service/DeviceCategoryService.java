package com.assetbookingapp.admin.service;

import com.assetbookingapp.admin.model.DeviceCategory;
import com.assetbookingapp.admin.repository.DeviceCategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviceCategoryService {

    private final DeviceCategoryRepository categoryRepository;

    public List<DeviceCategory> getDeviceCategories() {
        return categoryRepository.findAll();
    }

    public void addDeviceCategory(DeviceCategory deviceCategory) {
        Optional<DeviceCategory> category = categoryRepository.findByCategory(deviceCategory.getCategory());

        if (category.isPresent()) {
            throw new IllegalStateException("Device Category already exists");
        }

        categoryRepository.save(deviceCategory);
    }
}
