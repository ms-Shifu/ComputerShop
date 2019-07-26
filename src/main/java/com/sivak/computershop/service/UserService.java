package com.sivak.computershop.service;

import com.sivak.computershop.entities.Roles;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean matchPasswords(String password1, String password2) {
        return password1.equals(password2);
    }

    public boolean addNewUser(String username, String password1, String address, String phoneNumber) {

        Users userFromDB = userRepo.findByUsername(username);

        if (userFromDB != null) {
            return false;
        }

        Users user = new Users(username, password1, address, phoneNumber);
        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        userRepo.save(user);

        return true;
    }
}
