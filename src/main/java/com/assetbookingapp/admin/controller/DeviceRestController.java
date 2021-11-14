package com.assetbookingapp.admin.controller;

import com.assetbookingapp.admin.model.Device;
import com.assetbookingapp.admin.service.DeviceService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/devices")
@AllArgsConstructor
public class DeviceRestController {

    private final DeviceService deviceService;

    @GetMapping
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @GetMapping(path = "{deviceId}")
    public Device getDeviceById(@PathVariable("deviceId") Long deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @PostMapping
    public void registerNewDevice(@RequestBody Device deviceDto) {
        deviceService.addDevice(deviceDto);
    }

    @DeleteMapping(path = "{deviceId}")
    public void deleteDevice(@PathVariable("deviceId") Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }

    @PutMapping(path = "{deviceId}")
    public void updateDevice(@PathVariable("deviceId") Long deviceId,
                             @RequestParam(required = false) Boolean shared,
                             @RequestParam(required = false) String note,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookedFrom,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookedTo) {

        deviceService.updateDevice(deviceId, shared, note, bookedFrom, bookedTo);
    }
}
