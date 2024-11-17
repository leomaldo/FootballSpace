package models;
import javax.persistence.* ;
import play.db.jpa.* ;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket extends Model {

    private int numTickets;
    private float price;


    @ManyToMany (mappedBy = "tickets")
    public List<User> users = new ArrayList<User>();

    @OneToOne
    public Match match;

    public Ticket() {
    }

    public Ticket(int numTickets, float price) {

        this.numTickets = numTickets;
        this.price = price;
    }
}
