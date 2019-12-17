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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

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
        Users user = userRepo.findByUsername(username);
    
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return user;
    }
    

    public void matchPasswords(String password1, String password2, BindingResult bindingResult) {
        if (StringUtils.isEmpty(password2)) {
            ObjectError password2ObjectError = new FieldError("users","password2", "Confirm password can't be empty");
            bindingResult.addError(password2ObjectError);
            return;
        }

        if (!password1.equals(password2)) {
            ObjectError password2ObjectError = new FieldError("users", "password2", "Passwords aren't equals");
            bindingResult.addError(password2ObjectError);
            return;
        }
    }
    

    public boolean addNewUser(Users user) {

        Users userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

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
    
    public boolean matchMails(String email) {
        Users userRepoByEmail = userRepo.findByEmail(email);
    
        return (userRepoByEmail == null);
    }
}
