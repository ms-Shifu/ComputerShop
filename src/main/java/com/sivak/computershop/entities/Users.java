package com.sivak.computershop.entities;

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
//    @Column(name = "inCart", nullable = false,  columnDefinition = "INTEGER DEFAULT 0")
    private int inCart;
    private String address;
    private String phoneNumber;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "laptops_id")
    private List<Laptops> laptops;

    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tablets> tablets;

    public Users() {
    }

    public Users(String username, String password, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
//        this.active = active;
        this.address = address;
        this.phoneNumber = phoneNumber;
        inCart = 0;
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
        return inCart = laptops.size() + tablets.size();
    }

    public void setInCart(int inCart) {
        this.inCart = inCart;
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
}
