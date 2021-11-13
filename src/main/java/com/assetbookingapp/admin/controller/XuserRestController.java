package com.assetbookingapp.admin.controller;

import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.service.XuserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class XuserRestController {

    private final XuserService xuserService;

    @GetMapping
    public List<Xuser> getUsers() {
        return xuserService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public Xuser getUserById(@PathVariable("userId") Long userId) {
        return xuserService.getUserById(userId);
    }

    @PostMapping
    public void addNewUser(@RequestBody Xuser xuserDto) {
        xuserService.addUser(xuserDto);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        xuserService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) Boolean active) {
        xuserService.updateUser(userId, active);
    }
}
