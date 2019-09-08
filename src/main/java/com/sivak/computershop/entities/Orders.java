package com.sivak.computershop.entities;

import javax.persistence.*;
import javax.validation.valueextraction.UnwrapByDefault;
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

    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Phones> phones;
    
    private Boolean payed;

    public Orders() {
    }

    public Orders(Users user) {
        this.user = user;
        this.date = LocalDate.now();
        this.laptops = new ArrayList<>();
        this.tablets = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.payed = false;
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

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }
    
    public Boolean getPayed() {
        return payed;
    }
    
    public void setPayed(Boolean payed) {
        this.payed = payed;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (!id.equals(orders.id)) return false;
        if (!date.equals(orders.date)) return false;
        if (!user.equals(orders.user)) return false;
        if (laptops != null ? !laptops.equals(orders.laptops) : orders.laptops != null) return false;
        if (tablets != null ? !tablets.equals(orders.tablets) : orders.tablets != null) return false;
        return phones != null ? phones.equals(orders.phones) : orders.phones == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + (laptops != null ? laptops.hashCode() : 0);
        result = 31 * result + (tablets != null ? tablets.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }
}
