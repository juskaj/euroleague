package com.basketball.basketball.players;

import com.basketball.basketball.PlayerSeason.PlayerSeasons;
import com.basketball.basketball.PlayerSeason.PlayerSeasonsDTO;
import com.basketball.basketball.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayersController {

    @Autowired
    PlayersService playerService;

    @CrossOrigin
    @RequestMapping("/players")
    public ArrayList<PlayersDTO> getAllPlayers(){
        ArrayList<Players> players = (ArrayList<Players>) playerService.playerRepository.findByOrderBySurnameAsc();
        ArrayList<PlayersDTO> playersToReturn = new ArrayList<>();

        for(Players player: players){
            playersToReturn.add(Utils.convertPlayerToDTO(player));
        }

        return playersToReturn;
    }


    @CrossOrigin
    @RequestMapping("/players/{id}")
    public ResponseEntity<PlayersDTO> getPlayerById(@PathVariable("id") int id){
        Optional<Players> player = playerService.playerRepository.findById(id);
        if(player.isPresent()){
            return new ResponseEntity<PlayersDTO>(Utils.convertPlayerToDTO(player.get()), HttpStatus.OK);
        }
        return new ResponseEntity<PlayersDTO>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public ResponseEntity<PlayersDTO> updatePlayer(@RequestBody PlayersDTO playerDTO){
        Optional<Players> _player = playerService.playerRepository.findById(playerDTO.getId());

        if(_player.isPresent()){
            Players player = _player.get();
            player.setBirthdate(playerDTO.getBirthdate());
            player.setFullPicture(Utils.convertBase64ToBlob(playerDTO.getFullPicture()));
            player.setPicture(Utils.convertBase64ToBlob(playerDTO.getPicture()));
            player.setHeight(playerDTO.getHeight());
            player.setName(playerDTO.getName());
            player.setSurname(playerDTO.getSurname());
            player.setPosition(playerDTO.getPosition());
            player.setNumber(playerDTO.getNumber());
            playerService.playerRepository.save(player);

            return ResponseEntity.ok(playerDTO);
        }
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @RequestMapping(value = "/addPlayers", method = RequestMethod.POST)
    public ResponseEntity<PlayersDTO> updatePlayers(@RequestBody List<PlayersDTO> playersDTO){

        for(PlayersDTO playerDTO : playersDTO){
            Players player = new Players();
            player.setBirthdate(playerDTO.getBirthdate());
            player.setFullPicture(Utils.convertBase64ToBlob(playerDTO.getFullPicture()));
            player.setPicture(Utils.convertBase64ToBlob(playerDTO.getPicture()));
            player.setHeight(playerDTO.getHeight());
            player.setName(playerDTO.getName());
            player.setSurname(playerDTO.getSurname());
            player.setPosition(playerDTO.getPosition());
            player.setNumber(playerDTO.getNumber());
            playerService.playerRepository.save(player);
        }
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @RequestMapping(value = "removePlayer/{id}")
    public ResponseEntity<PlayersDTO> removePlayer(@PathVariable("id") int id){
        playerService.playerRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}