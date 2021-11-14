package com.assetbookingapp.admin.service;

import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Xuser> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(Xuser xuser) {
        Optional<Xuser> userByEmployeeId = userRepository.findByEmployeeId(xuser.getEmployeeId());

        if (userByEmployeeId.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        userRepository.save(xuser);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists) {
            throw new IllegalStateException("user with id: " + userId + " does not exist");
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, Boolean active) {

        Xuser xuser = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalStateException("user with id: " + userId + " does not exist"));

        if (!Objects.equals(active, xuser.getActive())) {
            xuser.setActive(active);
        }
    }

    public Xuser getUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new IllegalStateException("user with id: " + userId + " does not exist"));
    }
}
