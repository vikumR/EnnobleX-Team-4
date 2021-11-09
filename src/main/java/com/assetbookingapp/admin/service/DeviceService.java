package com.assetbookingapp.admin.service;

import com.assetbookingapp.admin.model.Device;
import com.assetbookingapp.admin.repository.DeviceRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public void addDevice(Device device) {
        Optional<Device> deviceByAssetNumber = deviceRepository.findByAssetNumber(device.getAssetNumber());

        if (deviceByAssetNumber.isPresent()) {
            throw new IllegalStateException("Device already exists");
        }

        deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        boolean exists = deviceRepository.existsById(deviceId);

        if (!exists) {
            throw new IllegalStateException("device with id: " + deviceId + " does not exist");
        }

        deviceRepository.deleteById(deviceId);
    }

    @Transactional
    public void updateDevice(Long deviceId, Boolean shared, String note) {

        Device device = deviceRepository.findById(deviceId)
            .orElseThrow(() -> new IllegalStateException("device with id: " + deviceId + " does not exist"));

        if (!note.equals(device.getNote())) {
            device.setNote(note);
        }

        if (!Objects.equals(shared, device.getShared())) {
            device.setShared(shared);
        }
    }

    public Device getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId)
            .orElseThrow(() -> new IllegalStateException("device with id: " + deviceId + " does not exist"));
    }
}
