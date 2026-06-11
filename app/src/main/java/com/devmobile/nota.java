package com.devmobile;

public class nota {

    Integer id;
    String titulo;
    String conteudo;

    public nota(Integer id, String titulo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }
    public nota(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }
}
