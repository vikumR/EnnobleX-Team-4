package com.assetbookingapp.admin.controller;

import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public List<Xuser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public Xuser getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public void addNewUser(@RequestBody Xuser xuserDto) {
        userService.addUser(xuserDto);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) Boolean active) {
        userService.updateUser(userId, active);
    }
}
