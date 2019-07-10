//package com.sivak.computershop.entities;
//
//import org.springframework.data.repository.cdi.Eager;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "usr")
//public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String username;
//    private String password;
//    private boolean active;
//    private int inCart;
//
//    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Roles> roles;
//
//
//}
