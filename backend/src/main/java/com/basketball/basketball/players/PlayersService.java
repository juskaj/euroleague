package com.basketball.basketball.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {

    @Autowired
    PlayersRepository playerRepository;

    public String getPlayerNameById(int id){
        Optional<Players> player = playerRepository.findById(id);

        if(player.isPresent()){
            return player.get().getName();
        }

        return null;
    }

}
