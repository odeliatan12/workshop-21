package nus.iss.module3.workshop21.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import nus.iss.module3.workshop21.model.Tvshow;
import nus.iss.module3.workshop21.service.TvShowService;

@RestController
@RequestMapping(path = "/tvshow", produces=MediaType.APPLICATION_JSON_VALUE)
public class TvshowController {
    
    @Autowired
    private TvShowService service;
    
    @GetMapping(path = "{tvId}")
    public ResponseEntity<String> getBook(@PathVariable Integer tvId) {
        Optional<Tvshow> opt = service.findshowbyID(tvId);

        if(opt.isEmpty())
            return ResponseEntity.status(404).body(
                Json.createObjectBuilder()
                    .add("message", "cannot find" + tvId)
                    .build()
                    .toString()
            );
        
        return ResponseEntity.ok(opt.get().toJSON().toString());
    }

}
