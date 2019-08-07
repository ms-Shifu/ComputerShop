package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    
    Users findByActivationCode(String code);
    
    Users findByEmail(String email);
}
