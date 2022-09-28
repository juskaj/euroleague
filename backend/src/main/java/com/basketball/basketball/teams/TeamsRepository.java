package com.basketball.basketball.teams;

import org.springframework.data.repository.CrudRepository;

public interface TeamsRepository extends CrudRepository<Teams, Integer> {

    public Iterable<Teams> findByOrderByName();
}
