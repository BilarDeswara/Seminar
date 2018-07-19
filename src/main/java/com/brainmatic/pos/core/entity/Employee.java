package com.brainmatic.pos.core.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;

    @Embedded
    private Address home;
//    private Address city;
    private LocalDate birdDate;

    public LocalDate getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(LocalDate birdDate) {
        this.birdDate = birdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birdDate.getYear();
    }

    public Employee(){
       this.birdDate = LocalDate.now().minusYears(25);
    }

    public Address getHome() {
        return home;
    }

    public void setHome(Address home) {
        this.home = home;
    }

//    public Address getCity() {
//        return city;
//    }
//
//    public void setCity(Address city) {
//        this.city = city;
//    }


}
