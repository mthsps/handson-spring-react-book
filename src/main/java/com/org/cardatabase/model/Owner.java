package com.org.cardatabase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "cars_owners", joinColumns = { @JoinColumn(name = "owner_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id", referencedColumnName = "id") })
    private Set<Car> cars = new HashSet<Car>(0);

    public Owner () {}

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
