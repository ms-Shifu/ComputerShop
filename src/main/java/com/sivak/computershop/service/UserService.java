package com.sivak.computershop.service;

import com.sivak.computershop.entities.Roles;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    
    @Value("${myhostname}")
    protected String myhostname;
    
    @Autowired
    private MailService mailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean matchPasswords(String password1, String password2) {
        return password1.equals(password2);
    }

    public boolean addNewUser(String username, String password1, String email, String address, String phoneNumber) {

        Users userFromDB = userRepo.findByUsername(username);

        if (userFromDB != null) {
            return false;
        }

        Users user = new Users(username, password1, email, address, phoneNumber);
        user.setActive(false);
        user.setRoles(Collections.singleton(Roles.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        
        userRepo.save(user);
    
        if (!StringUtils.isEmpty(user.getEmail())) {
            
            String message = String.format("Hallo, %s.\nFor activation your account on ComputerShop visit next link: %s/activate/%s", user.getUsername(), myhostname, user.getActivationCode());
    
            mailService.send(user.getEmail(), "Activating account", message);
        }

        return true;
    }
    
    public boolean activate(String code) {
    
        Users user = userRepo.findByActivationCode(code);
    
        if (user == null) {
            return false;
        }
        
        user.setActivationCode(null);
        user.setActive(true);
    
        userRepo.save(user);
    
        return true;
    }
    
    public boolean passwordRecoverySend(String email) {
    
        if (StringUtils.isEmpty(email)) {
            return false;
        }
    
        Users user = userRepo.findByEmail(email);
    
        if (user == null) {
            return false;
        }
    
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Password for user %s: %s", user.getUsername(), user.getPassword());
            
            mailService.send(email, "Password recover", message);
        }
    
        return true;
    }
}
