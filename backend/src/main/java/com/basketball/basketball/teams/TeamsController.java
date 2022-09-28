package com.basketball.basketball.teams;

import com.basketball.basketball.Utils;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamsController {

    private ServletContext servletContext;

    @Autowired
    TeamsService teamsService;

    @CrossOrigin
    @RequestMapping("/teams")
    public ResponseEntity<List<TeamsDTO>> getAllTeams(){
        Iterable<Teams> teams = teamsService.teamsRepository.findByOrderByName();
        ArrayList<TeamsDTO> teamsToReturn = new ArrayList<>();
        for (Teams team: teams) {
            TeamsDTO teamToReturn = new TeamsDTO();
            teamToReturn.setId(team.getId());
            teamToReturn.setName(team.getName());
            teamToReturn.setPrimaryColor(team.getPrimaryColor());
            teamToReturn.setLogo(Utils.convertBlobToBase64(team.getLogo()));
            teamToReturn.setTeamPicture(Utils.convertBlobToBase64(team.getTeamPicture()));
            teamsToReturn.add(teamToReturn);
        }
        return ResponseEntity.ok().body(teamsToReturn);
    }

    @CrossOrigin
    @RequestMapping("/teams/{id}")
    public ResponseEntity<TeamsDTO> getTeamByID(@PathVariable("id") int id){
        Optional<Teams> _team = teamsService.teamsRepository.findById(id);
        if(_team.isPresent()){
            Teams team = _team.get();
            TeamsDTO teamToReturn = new TeamsDTO();
            teamToReturn.setId(team.getId());
            teamToReturn.setName(team.getName());
            teamToReturn.setPrimaryColor(team.getPrimaryColor());
            teamToReturn.setLogo(Utils.convertBlobToBase64(team.getLogo()));
            teamToReturn.setTeamPicture(Utils.convertBlobToBase64(team.getTeamPicture()));
            return ResponseEntity.ok().body(teamToReturn);
        }

        return ResponseEntity.status(404).body(null);
    }

    @CrossOrigin
    @RequestMapping(path = "/updateTeam", method = RequestMethod.POST)
    public ResponseEntity<TeamsDTO> updateTeam(@RequestBody TeamsDTO teamDTO){
        Optional<Teams> _team = teamsService.teamsRepository.findById(teamDTO.getId());

        if(_team.isPresent()){
            Teams team = _team.get();
            team.setName(teamDTO.getName());
            team.setPrimaryColor(teamDTO.getPrimaryColor());
            team.setLogo(Utils.convertBase64ToBlob(teamDTO.getLogo()));
            team.setTeamPicture(Utils.convertBase64ToBlob(teamDTO.getTeamPicture()));
            teamsService.teamsRepository.save(team);
            return ResponseEntity.ok(teamDTO);
        }
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @RequestMapping(path = "/addTeams")
    public ResponseEntity<TeamsDTO> addTeams(@RequestBody List<TeamsDTO> teamsDTO){
        List<Teams> teamsToAdd = new ArrayList<>();
        for(TeamsDTO teamDTO: teamsDTO){
            Teams team = new Teams();
            team.setName(teamDTO.getName());
            team.setPrimaryColor(teamDTO.getPrimaryColor());
            team.setLogo(teamDTO.getLogo() != null ? Utils.convertBase64ToBlob(teamDTO.getLogo()) : null);
            team.setTeamPicture(teamDTO.getLogo() != null ? Utils.convertBase64ToBlob(teamDTO.getTeamPicture()) : null);
            teamsToAdd.add(team);
        }
        teamsService.teamsRepository.saveAll(teamsToAdd);
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @RequestMapping("/removeTeam/{id}")
    public ResponseEntity<TeamsDTO> removeTeam(@PathVariable("id") int id){
        Optional<Teams> team = teamsService.teamsRepository.findById(id);

        if(team.isPresent()){
            teamsService.teamsRepository.deleteById(id);
        }
        return ResponseEntity.ok(null);
    }
}
