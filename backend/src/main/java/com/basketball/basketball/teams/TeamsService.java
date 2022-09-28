package com.basketball.basketball.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamsService {

    @Autowired
    TeamsRepository teamsRepository;
}
