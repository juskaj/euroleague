package com.basketball.basketball.Positions;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Positions {
    @Id
    private int id;
    private String name;

    public Positions() {
    }

    public Positions(int id, String name) {
        this.id = id;
        this.name = name;
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
}
