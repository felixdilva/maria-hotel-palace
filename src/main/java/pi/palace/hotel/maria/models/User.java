package pi.palace.hotel.maria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pi.palace.hotel.maria.enums.Papel;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Papel papel;

    

    

    public User() {
    }

    public User(Long id, String nome, String email, String senha, Papel papel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public User( String nome, String email, String senha, Papel papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Papel getPapel() {
        return papel;
    }

}
