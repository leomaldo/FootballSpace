package models;

import java.util.*;
import javax.persistence.* ;

@Entity
public class Usuario extends Model {
    private String nome;
    private String email;
    private String telefone;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

}
