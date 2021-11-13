package com.assetbookingapp.admin.repository;

import com.assetbookingapp.admin.model.Xuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface XuserRepository extends JpaRepository<Xuser, Long> {

    @Query("SELECT u FROM Xuser u WHERE u.employeeId = ?1")
    Optional<Xuser> findByEmployeeId(String employeeId);
}
