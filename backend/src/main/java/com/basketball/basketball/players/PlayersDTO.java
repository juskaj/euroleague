package com.basketball.basketball.players;

import com.basketball.basketball.Positions.Positions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class PlayersDTO {

    @Id
    private int id;
    private String name;
    private String surname;
    private Date birthdate;
    private int height;
    @ManyToOne
    private Positions position;
    String picture;
    String fullPicture;
    private int number;

    public PlayersDTO() {
    }

    public PlayersDTO(int id, String name, String surname, Date birthdate, int height, Positions position, String picture, String fullPicture, int number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.height = height;
        this.position = position;
        this.picture = picture;
        this.fullPicture = fullPicture;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFullPicture() {
        return fullPicture;
    }

    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(Date birthDate) {
        this.birthdate = birthDate;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public int getHeight() {
        return height;
    }
}
