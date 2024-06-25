package com.projetosrafaelfemina.blocodenotas.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class NotePreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    public NotePreferences(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void SaveNotes(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String RecoverNotes() {
        return preferences.getString(CHAVE_NOME, "");
    }

}
