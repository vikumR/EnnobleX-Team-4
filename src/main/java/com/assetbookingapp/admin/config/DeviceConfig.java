package com.assetbookingapp.admin.config;

import com.assetbookingapp.admin.model.Device;
import com.assetbookingapp.admin.repository.DeviceRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DeviceConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeviceRepository deviceRepository) {
        return args -> {
            Device device = new Device(
                "testAssetNumber",
                "testBrand",
                "testModel",
                "testSerialNumber",
                false,
                false,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));

            Device device1 = new Device(
                "testAssetNumber1",
                "testBrand1",
                "testModel1",
                "testSerialNumber1",
                false,
                false,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(20));

            deviceRepository.saveAll(Arrays.asList(device, device1));
        };
    }
}
