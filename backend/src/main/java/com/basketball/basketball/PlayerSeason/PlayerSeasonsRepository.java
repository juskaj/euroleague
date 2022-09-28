package com.basketball.basketball.PlayerSeason;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PlayerSeasonsRepository extends CrudRepository<PlayerSeasons, Integer> {
    public ArrayList<PlayerSeasons> findAllBySeason_Id(int seasonId);
}
