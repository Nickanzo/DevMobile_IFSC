package com.devmobile;

import android.content.Context;

import java.util.ArrayList;

public class notaController {

    private notaDAO notaDAO;

    public notaController(Context context) {
        notaDAO = new notaDAO(context);
    }

    public void inserirNovaNota(nota n){
        notaDAO.insereNota(n);
    }

    public boolean deleteNota(int id){

        return false;
    }

    public ArrayList<nota> listarNotas(){

        return new ArrayList<>();

    }

    public nota getNota(int i){

        return notaDAO.getNota(i);

    }

    public ArrayList<String> listaTitulosNotas(){

        ArrayList<nota> notas = this.listarNotas();
        ArrayList<String > titulosNotas = new ArrayList<>();

        for( nota n : notas ){
            titulosNotas.add(n.titulo);
        }

        return titulosNotas;
    }


}
