package com.example.applogin;

import android.app.Application;

/**
 * Created by Freddy on 30/09/2015.
 */
public class Aplicacion extends Application{
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
