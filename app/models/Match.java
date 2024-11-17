package models;
import javax.persistence.* ;
import play.db.jpa.* ;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Match extends Model {



    private String data;

    private String city;

    //private



    @ManyToMany
    public List<Team> teams=new ArrayList<Team>();

    @OneToOne
    public Ticket ticket;


    public Match() {
    }

    public Match(String city, String data) {

        this.city = city;
        this.data = data;

    }


}
