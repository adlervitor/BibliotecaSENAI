package org.senai.entidades;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private String tipo;
    private String status;

    // construtor
    public Livro(int id, String nome, String autor, String tipo, String status) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.tipo = tipo;
        this.status = status;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro ID: " + this.id +
                ", Nome: " + this.nome +
                ", Autor: " + this.autor +
                ", Tipo: " + this.tipo +
                ", Status: " + this.status;
    }
}

