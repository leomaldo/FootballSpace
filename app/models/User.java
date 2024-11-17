package models;

import javax.persistence.* ;
import play.db.jpa.* ;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Model {
    private String name;

    private String password;
    private String email;
    private String telefone;

    @ManyToMany
    public List<Ticket> tickets = new ArrayList<Ticket>();
    public User() {
    }

    public User(String name, String email, String telefone, String password) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
    }



}
