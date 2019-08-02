package com.sivak.computershop.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class OrdersCompleted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Users user;
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Laptops> laptops;
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tablets> tablets;
    @OrderColumn
    @ManyToMany
    private List<Phones> phones;
    private LocalDate date;

    public OrdersCompleted() {
    }

    public OrdersCompleted(Long id, Users user, List<Laptops> laptops, List<Tablets> tablets,
                           List<Phones> phones) {
        this.id = id;
        this.user = user;
        this.laptops = laptops;
        this.tablets = tablets;
        this.phones = phones;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Laptops> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptops> laptops) {
        this.laptops = laptops;
    }

    public List<Tablets> getTablets() {
        return tablets;
    }

    public void setTablets(List<Tablets> tablets) {
        this.tablets = tablets;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }
}
