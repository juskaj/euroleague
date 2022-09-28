package com.basketball.basketball.PlayerSeason;

import com.basketball.basketball.Utils;
import com.basketball.basketball.players.Players;
import com.basketball.basketball.players.PlayersDTO;
import com.basketball.basketball.seasons.Seasons;
import com.basketball.basketball.teams.Teams;
import com.basketball.basketball.teams.TeamsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlayerSeasonsController {

    @Autowired
    PlayerSeasonsService playerSeasonsService;

    @CrossOrigin
    @RequestMapping("/getSeasons/teamId/{teamId}")
    public ResponseEntity<Iterable<PlayerSeasonsDTO>> getPlayerSeasonsByTeamId(@PathVariable("teamId") int teamId){
        ArrayList<PlayerSeasons> playerSeasons = playerSeasonsService.getPlayerSeasonsByTeamId(teamId);
        return ResponseEntity.ok().body(Utils.convertPlayerSeasonsToDTO(playerSeasons));
    }

    @CrossOrigin
    @RequestMapping("/getSeasons/seasonId/{seasonId}")
    public ResponseEntity<Iterable<PlayerSeasonsDTO>> getPlayerSeasonsBySeasonId(@PathVariable("seasonId") int seasonId){
        ArrayList<PlayerSeasons> playerSeasons = playerSeasonsService.getPlayerSeasonsByTeamId(seasonId);
        return ResponseEntity.ok().body(Utils.convertPlayerSeasonsToDTO(playerSeasons));
    }

    @CrossOrigin
    @RequestMapping("/getPlayersBySeasonsAndTeam/{seasonId}/{teamId}")
    public ResponseEntity<Iterable<PlayersDTO>> getPlayersBySeasonsAndTeam(@PathVariable("seasonId") int seasonId, @PathVariable("teamId") int teamId){
        ArrayList<Players> playerSeasons = playerSeasonsService.getPlayersBySeasonIdAndTeamId(seasonId, teamId);
        ArrayList<PlayersDTO> playersToReturn = new ArrayList<>();

        for(Players player: playerSeasons){
            playersToReturn.add(Utils.convertPlayerToDTO(player));
        }

        return ResponseEntity.ok().body(playersToReturn);
    }

    @CrossOrigin
    @RequestMapping("/getSeasons")
    public ResponseEntity<Iterable<PlayerSeasonsDTO>> getPlayerSeasons(){
        ArrayList<PlayerSeasons> playerSeasons = (ArrayList<PlayerSeasons>) playerSeasonsService.playerSeasonsRepository.findAll();
        return ResponseEntity.ok().body(Utils.convertPlayerSeasonsToDTO(playerSeasons));
    }

    @CrossOrigin
    @RequestMapping("/getSeasonsByTeamId/{id}")
    public ResponseEntity<Iterable<Seasons>> getSeasonsByTeamId(@PathVariable("id") int id){
        ArrayList<PlayerSeasons> playerSeasons = (ArrayList<PlayerSeasons>) playerSeasonsService.playerSeasonsRepository.findAll();
        ArrayList<Seasons> filteredSeasons = new ArrayList<>();
        for(PlayerSeasons playerSeason : playerSeasons){
            boolean flag = false;
            for(Seasons season : filteredSeasons){
                if(season.getId() == playerSeason.getSeason().getId()){
                    flag = true;
                    break;
                }
            }
            if(!flag && playerSeason.getTeam().getId() == id){
                filteredSeasons.add(playerSeason.getSeason());
            }
        }
        return ResponseEntity.ok(filteredSeasons);
    }

    @CrossOrigin
    @RequestMapping("/getTeamsBySeasonId/{id}")
    public ResponseEntity<Iterable<Teams>> getTeamsBySeasonId(@PathVariable("id") int id){
        ArrayList<PlayerSeasons> playerSeasons = playerSeasonsService.playerSeasonsRepository.findAllBySeason_Id(id);
        ArrayList<Teams> allTeams = new ArrayList<>();

        for(PlayerSeasons playerSeason: playerSeasons){
            if(!allTeams.contains(playerSeason.getTeam())){
                allTeams.add(playerSeason.getTeam());
            }
        }

        return ResponseEntity.ok(allTeams);
    }
}
