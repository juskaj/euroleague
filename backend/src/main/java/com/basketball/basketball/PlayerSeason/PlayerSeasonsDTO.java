package com.basketball.basketball.PlayerSeason;

import com.basketball.basketball.players.Players;
import com.basketball.basketball.seasons.Seasons;
import com.basketball.basketball.teams.Teams;
import com.basketball.basketball.teams.TeamsDTO;

import javax.persistence.*;

@Entity
@Table(name = "season_team_players")
public class PlayerSeasonsDTO {

    @Id
    private int id;
    @ManyToOne
    private Players player;
    @ManyToOne
    private Seasons season;
    @ManyToOne
    private TeamsDTO team;

    public PlayerSeasonsDTO() {
    }

    public PlayerSeasonsDTO(int id, Players player, Seasons season, TeamsDTO team) {
        this.id = id;
        this.player = player;
        this.season = season;
        this.team = team;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public Seasons getSeason() {
        return season;
    }

    public void setSeason(Seasons season) {
        this.season = season;
    }

    public TeamsDTO getTeam() {
        return team;
    }

    public void setTeam(TeamsDTO team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
