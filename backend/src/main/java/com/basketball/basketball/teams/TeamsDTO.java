package com.basketball.basketball.teams;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamsDTO {

    @Id
    private int id;
    private String name;
    private String logo;
    private String teamPicture;
    private String primaryColor;

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public TeamsDTO(int id, String name, String logo, String primaryColor, String teamPicture) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.primaryColor = primaryColor;
        this.teamPicture = teamPicture;
    }

    public TeamsDTO() {
    }

    public String getTeamPicture() {
        return teamPicture;
    }

    public void setTeamPicture(String teamPicture) {
        this.teamPicture = teamPicture;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
