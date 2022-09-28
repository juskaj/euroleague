package com.basketball.basketball.players;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayersRepository extends CrudRepository<Players, Integer> {

    List<Players> findByOrderBySurnameAsc();
}
