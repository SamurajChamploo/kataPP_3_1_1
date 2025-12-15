package com.example.kataPP_3_1_1.repository;

import com.example.kataPP_3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
}
