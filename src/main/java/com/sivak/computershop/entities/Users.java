package com.sivak.computershop.entities;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private String address;
    private String phoneNumber;
    private String email;
    private String activationCode;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Laptops> laptops;

    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private List<Tablets> tablets;

    @OrderColumn(name = "orderphone_id")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Phones> phones;

    public Users() {
    }

    public Users(String username, String password, String email, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getInCart() {
        return laptops.size() + tablets.size() + phones.size();
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public List<Laptops> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptops> laptops) {
        this.laptops = laptops;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return this.roles.contains(Roles.ADMIN);
    }

    public List<Tablets> getTablets() {
        return tablets;
    }

    public void setTablets(List<Tablets> tablets) {
        this.tablets = tablets;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getActivationCode() {
        return activationCode;
    }
    
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Users users = (Users) o;
        
        if (active != users.active) return false;
        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(users.phoneNumber) : users.phoneNumber != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (activationCode != null ? !activationCode.equals(users.activationCode) : users.activationCode != null)
            return false;
        if (roles != null ? !roles.equals(users.roles) : users.roles != null) return false;
        if (laptops != null ? !laptops.equals(users.laptops) : users.laptops != null) return false;
        if (tablets != null ? !tablets.equals(users.tablets) : users.tablets != null) return false;
        return phones != null ? phones.equals(users.phones) : users.phones == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (activationCode != null ? activationCode.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (laptops != null ? laptops.hashCode() : 0);
        result = 31 * result + (tablets != null ? tablets.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }
}
