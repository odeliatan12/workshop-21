package nus.iss.module3.workshop21.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import nus.iss.module3.workshop21.model.Tvshow;
import nus.iss.module3.workshop21.repository.TvshowRepository;

@Service
public class TvShowService {

    @Autowired
    private TvshowRepository repository;
    
    public Optional<Tvshow> findshowbyID(final Integer tvID) {
        SqlRowSet rowSet = repository.get(tvID);

        if(rowSet.first()){
            return Optional.of(Tvshow.populate(rowSet));
        } 
        return Optional.empty();
    }
}
