package nus.iss.module3.workshop21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Tvshow {

    private Integer tvId;
    private String name;

    public Integer getTvId() {
        return tvId;
    }
    public void setTvId(int i) {
        this.tvId = i;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public static Tvshow populate(SqlRowSet rs){
        final Tvshow tv = new Tvshow();
        tv.setTvId(Integer.parseInt(rs.getString("tvId")));
        tv.setName(rs.getString("name"));
        return tv;
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
                    .add("tvId", this.getTvId())
                    .add("name", this.getName())
                    .build();
    }
}
