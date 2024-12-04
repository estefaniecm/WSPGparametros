package com.guatex.parametros.entidades;

import java.util.List;


/**
 *
 * @author ESTEFANIECM
 */
public class E_RespuestaParametros {

    private String codigo = "";
    private String mensaje = "";
    private List<E_Parametro> listaParametros;

     public E_RespuestaParametros(String pCodigo, List<E_Parametro> plistaParametros) {
        this.codigo = pCodigo;
        this.listaParametros = plistaParametros;
        if (pCodigo.equalsIgnoreCase("200")) {
            this.mensaje = "OK";
            this.listaParametros = plistaParametros;
        } else if (pCodigo.equalsIgnoreCase("500")) {
            this.mensaje = "Error en el servidor";
        } else if (pCodigo.equalsIgnoreCase("204")) {
            this.mensaje = "No se obtuvo información de la base de datos";
        }
    }
     
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<E_Parametro> getParametros() {
        return listaParametros;
    }

    public void setParametros(List<E_Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }
    
    
}
