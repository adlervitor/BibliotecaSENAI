package org.senai.entidades;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String sexo;

    // construtor
    public Cliente(int id, String nome, String email, String sexo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String toString() {
        return "Cliente ID: " + this.id +
                ", Nome: " + this.nome +
                ", Email: " + this.email +
                ", Sexo: " + this.sexo;
    }
}

