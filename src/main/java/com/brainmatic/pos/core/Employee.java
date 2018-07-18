package com.brainmatic.pos.core;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
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
}
