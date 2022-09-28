package com.basketball.basketball;

import com.basketball.basketball.PlayerSeason.PlayerSeasons;
import com.basketball.basketball.PlayerSeason.PlayerSeasonsDTO;
import com.basketball.basketball.players.Players;
import com.basketball.basketball.players.PlayersDTO;
import com.basketball.basketball.teams.Teams;
import com.basketball.basketball.teams.TeamsDTO;

import java.util.ArrayList;
import java.util.Base64;

public class Utils {

    public static String convertBlobToBase64(byte[] blob){
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(blob);
    }
    public static byte[] convertBase64ToBlob(String base64){

        return Base64.getDecoder().decode(base64.substring(22));
    }

    public static PlayersDTO convertPlayerToDTO(Players players){
        PlayersDTO playersDTO = new PlayersDTO();

        playersDTO.setId(players.getId());
        playersDTO.setBirthdate(players.getBirthdate());
        playersDTO.setName(players.getName());
        playersDTO.setSurname(players.getSurname());
        playersDTO.setPosition(players.getPosition());
        playersDTO.setHeight(players.getHeight());
        playersDTO.setPicture(convertBlobToBase64(players.getPicture()));
        playersDTO.setFullPicture(convertBlobToBase64(players.getFullPicture()));
        playersDTO.setNumber(players.getNumber());

        return playersDTO;
    }

    public static ArrayList<PlayerSeasonsDTO> convertPlayerSeasonsToDTO(ArrayList<PlayerSeasons> playerSeasons){
        ArrayList<PlayerSeasonsDTO> playerSeasonsToReturn = new ArrayList<>();

        for(PlayerSeasons season : playerSeasons){
            PlayerSeasonsDTO seasonDTO = new PlayerSeasonsDTO();

            Teams team = season.getTeam();

            TeamsDTO teamsDTO = new TeamsDTO();
            teamsDTO.setPrimaryColor(team.getPrimaryColor());
            teamsDTO.setName(team.getName());
            teamsDTO.setId(team.getId());
            teamsDTO.setLogo(Utils.convertBlobToBase64(team.getLogo()));

            seasonDTO.setSeason(season.getSeason());
            seasonDTO.setPlayer(season.getPlayer());
            seasonDTO.setTeam(teamsDTO);

            playerSeasonsToReturn.add(seasonDTO);
        }

        return playerSeasonsToReturn;
    }
}
