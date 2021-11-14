package com.assetbookingapp.admin.controller;

import com.assetbookingapp.admin.model.DeviceCategory;
import com.assetbookingapp.admin.service.DeviceCategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/categories")
@AllArgsConstructor
public class DeviceCategoryRestController {

    private final DeviceCategoryService categoryService;

    @GetMapping
    public List<DeviceCategory> getDeviceCategories() {
        return categoryService.getDeviceCategories();
    }

    @PostMapping
    public void createNewDeviceCategory(@RequestBody DeviceCategory category) {
        categoryService.addDeviceCategory(category);
    }

}
