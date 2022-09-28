package com.basketball.basketball.PlayerSeason;

import com.basketball.basketball.players.Players;
import com.basketball.basketball.players.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerSeasonsService {

    @Autowired
    PlayerSeasonsRepository playerSeasonsRepository;

    public ArrayList<PlayerSeasons> getPlayerSeasonsByTeamId(int id){
        ArrayList<PlayerSeasons> playerSeasons = (ArrayList<PlayerSeasons>) playerSeasonsRepository.findAll();
        ArrayList<PlayerSeasons> filteredPlayerSeasons = new ArrayList<>();
        for(PlayerSeasons season : playerSeasons){
            if(season.getTeam().getId() == id){
                filteredPlayerSeasons.add(season);
            }
        }

        return filteredPlayerSeasons;
    }

    public ArrayList<Players> getPlayersBySeasonIdAndTeamId(int seasonId, int teamId){
        ArrayList<PlayerSeasons> playerSeasons = (ArrayList<PlayerSeasons>) playerSeasonsRepository.findAll();
        ArrayList<Players> filteredPlayers = new ArrayList<>();
        for(PlayerSeasons season : playerSeasons){
            if(season.getTeam().getId() == teamId && season.getSeason().getId() == seasonId){
                filteredPlayers.add(season.getPlayer());
            }
        }

        return filteredPlayers;
    }

    public ArrayList<PlayerSeasons> getPlayerSeasonsBySeasonId(int id){
        ArrayList<PlayerSeasons> playerSeasons = (ArrayList<PlayerSeasons>) playerSeasonsRepository.findAll();
        ArrayList<PlayerSeasons> filteredPlayerSeasons = new ArrayList<>();
        for(PlayerSeasons season : playerSeasons){
            if(season.getSeason().getId() == id){
                filteredPlayerSeasons.add(season);
            }
        }

        return filteredPlayerSeasons;
    }
}
