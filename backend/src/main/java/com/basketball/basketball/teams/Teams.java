package com.basketball.basketball.teams;

import com.basketball.basketball.PlayerSeason.PlayerSeasons;
import com.basketball.basketball.players.Players;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Teams {

    @Id
    private int id;
    private String name;
    private byte[] logo;
    private byte[] teamPicture;
    private String primaryColor;

    public Teams(int id, String name, byte[] logo, String primaryColor, byte[] teamPicture) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.primaryColor = primaryColor;
        this.teamPicture = teamPicture;
    }

    public Teams() {
    }

    public byte[] getTeamPicture() {
        return teamPicture;
    }

    public void setTeamPicture(byte[] teamPicture) {
        this.teamPicture = teamPicture;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
