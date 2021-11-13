package com.assetbookingapp.admin.service;

import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.repository.XuserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class XuserService {

    private final XuserRepository xuserRepository;

    public List<Xuser> getUsers() {
        return xuserRepository.findAll();
    }

    public void addUser(Xuser xuser) {
        Optional<Xuser> userByEmployeeId = xuserRepository.findByEmployeeId(xuser.getEmployeeId());

        if (userByEmployeeId.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        xuserRepository.save(xuser);
    }

    public void deleteUser(Long userId) {
        boolean exists = xuserRepository.existsById(userId);

        if (!exists) {
            throw new IllegalStateException("user with id: " + userId + " does not exist");
        }

        xuserRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, Boolean active) {

        Xuser xuser = xuserRepository.findById(userId)
            .orElseThrow(() -> new IllegalStateException("user with id: " + userId + " does not exist"));

        if (!Objects.equals(active, xuser.getActive())) {
            xuser.setActive(active);
        }
    }

    public Xuser getUserById(Long userId) {
        return xuserRepository.findById(userId)
            .orElseThrow(() -> new IllegalStateException("user with id: " + userId + " does not exist"));
    }
}
