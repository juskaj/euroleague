package com.basketball.basketball.seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonsService {

    @Autowired
    SeasonsRepository seasonsRepository;
}
