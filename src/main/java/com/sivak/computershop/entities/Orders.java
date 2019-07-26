package com.sivak.computershop.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Users user;
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Laptops> laptops;
    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tablets> tablets;

    public Orders() {
    }

    public Orders(Users user) {
        this.user = user;
        this.date = LocalDate.now();
        this.laptops = new ArrayList<>();
        this.tablets = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}
