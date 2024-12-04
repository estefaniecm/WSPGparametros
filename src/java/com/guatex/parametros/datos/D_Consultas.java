package com.guatex.parametros.datos;

import com.guatex.parametros.entidades.E_Parametro;
import com.guatex.parametros.entidades.E_RespuestaParametros;
import com.guatex.parametros.utils.ConvertidorXML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ESTEFANIECM
 */
public class D_Consultas {

    public E_RespuestaParametros obtenerParametros(String datos) {
        List<E_Parametro> listaParametros = new LinkedList<>();
        String portal = new ConvertidorXML().extraerPortal(datos);

        String query = "SELECT SISTEMA, IDENTIFICADOR, VALOR FROM PARAMETROS WHERE SISTEMA = ? ";

        try (Connection con = new Conexion().AbrirConexion()) {
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, portal);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        E_Parametro p = new E_Parametro();
                        p.setSistema(quitaNulo(rs.getString("SISTEMA")));
                        p.setIdentificador(quitaNulo(rs.getString("IDENTIFICADOR")));
                        p.setValor(quitaNulo(rs.getString("VALOR")));
                        listaParametros.add(p);
                    }
                    if(!listaParametros.isEmpty()){
                        return new E_RespuestaParametros("200", listaParametros);
                    }else{
                        return new E_RespuestaParametros("204", listaParametros);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.out.println(e.getLocalizedMessage());
            return new E_RespuestaParametros("500", listaParametros);
        }
    }

    private String quitaNulo(String txt) {
        return txt == null ? "" : txt.trim();
    }

}
