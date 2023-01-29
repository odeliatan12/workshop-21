package nus.iss.module3.workshop21.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import nus.iss.module3.workshop21.model.Tvshow;

@Repository
public class TvshowRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Obtaining data from the database
    public List<Tvshow> getTvShows(final int limit, final int offset) {

        final List<Tvshow> result = new LinkedList<>();

        // Querying from the database
        final SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from tv_shows limit ? offset ?", limit, offset);

        while(rs.next()) {
            Tvshow tvshow = new Tvshow();
            tvshow.setTvId(rs.getInt("tv_id"));
            tvshow.setName(rs.getString("name"));
            result.add(tvshow);
        }
        return Collections.unmodifiableList(result);
    }

    public SqlRowSet get(final Integer tvId){
        return jdbcTemplate.queryForRowSet("select * from tv_shows where prog_id= ?", tvId);
    }
}
