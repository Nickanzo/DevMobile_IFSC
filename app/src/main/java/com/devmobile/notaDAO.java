package com.devmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class notaDAO {

    private SQLiteDatabase sqldb;
    ContentValues cv;

    public notaDAO(Context context) {
        sqldb = context.openOrCreateDatabase("banco.db", Context.MODE_PRIVATE, null);
        sqldb.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT , titulo TEXT, conteudo TEXT)");
    }

    public nota insereNota(nota n){
        if(n!=null){
            cv = new ContentValues();
            cv.put("titulo", n.titulo);
            cv.put("conteudo", n.conteudo);

            int id = (int) sqldb.insert("notas", null, cv );
            return new nota(id, n.titulo, n.conteudo);
        }
        return null;
    }

    public nota getNota(int id){
        Cursor cursor = sqldb.rawQuery("SELECT * FROM notas WHERE id=?", new String[]{Integer.toString(id)});
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            return new nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        return null;
    }

    public ArrayList<nota> listarNotas(){

        ArrayList result = new ArrayList<>();

        Cursor cursor = sqldb.rawQuery("SELECT * FROM notas WHERE id=?", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            result.add(new nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        return result;
    }

}
