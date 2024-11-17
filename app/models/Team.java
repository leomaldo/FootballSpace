package models;
import javax.persistence.* ;
import play.db.jpa.* ;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends Model{

    private String name;
    private String name_stadium;

    //escudo

    @ManyToMany (mappedBy = "teams")
    public List<Match> matches = new ArrayList<Match>();

    public Team() {
    }

    public Team(String name, String name_stadium) {
        this.name = name;
        this.name_stadium = name_stadium;

    }
}
