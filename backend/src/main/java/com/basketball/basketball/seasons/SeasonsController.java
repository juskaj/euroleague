package com.basketball.basketball.seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeasonsController {

    @Autowired
    SeasonsService seasonsService;

    @CrossOrigin
    @RequestMapping("/getAllSeasons")
    public ResponseEntity<Iterable<Seasons>> getAllSeasons(){
        return ResponseEntity.ok(seasonsService.seasonsRepository.findAll());
    }
}
