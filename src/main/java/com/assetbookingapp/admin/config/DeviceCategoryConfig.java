package com.assetbookingapp.admin.config;

import com.assetbookingapp.admin.model.DeviceCategory;
import com.assetbookingapp.admin.repository.DeviceCategoryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DeviceCategoryConfig {
    @Bean
    CommandLineRunner commandLineRunnerForCategory(DeviceCategoryRepository categoryRepository) {

        return args -> {
            DeviceCategory category = new DeviceCategory(
                "testDeviceCategory");

            DeviceCategory category1 = new DeviceCategory(
                "testDeviceCategory1");

            categoryRepository.saveAll(Arrays.asList(category, category1));
        };
    }
}
