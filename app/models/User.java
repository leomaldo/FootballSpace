package models;

import javax.persistence.* ;
import play.db.jpa.* ;

@Entity
public class User extends Model {
    private String nome;
    private String email;
    private String telefone;

    public User() {
    }

    public User(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

}
