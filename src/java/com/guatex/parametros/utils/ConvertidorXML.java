package com.guatex.parametros.utils;

import com.guatex.parametros.entidades.E_Parametro;
import com.guatex.parametros.entidades.E_RespuestaParametros;
import java.util.LinkedList;

/**
 *
 * @author ESTEFANIECM
 */
public class ConvertidorXML {

    public String extraerPortal(String xml) {
        return getTag("IDPORTAL", xml).trim();
    }

    public String respuestaXML(E_RespuestaParametros data) {

        String XML = "<RESPUESTA>"
                + addTag("CODIGO", data.getCodigo())
                + addTag("MENSAJE", data.getMensaje())
                + "<LISTADO_PARAMETROS>";
        if (data.getParametros().size() > 0) {
            for (E_Parametro parametro : data.getParametros()) {
                XML += "<PARAMETRO>"
                        + addTag("SISTEMA", parametro.getSistema())
                        + addTag("IDENTIFICADOR", parametro.getIdentificador())
                        + addTag("VALOR", parametro.getValor())
                        + "</PARAMETRO>";
            }
        } else {
            data.setParametros(new LinkedList<E_Parametro>());
        }
        XML += "</LISTADO_PARAMETROS>"
                + "</RESPUESTA>";
        System.out.println(XML);
        return XML;
    }

    public String getTag(String tag, String dato) {
        String respuesta = dato;
        if (dato.contains("<" + tag + ">")) {
            respuesta = dato.substring(dato.indexOf("<" + tag + ">"), dato.indexOf("</" + tag + ">")).replace("<" + tag + ">", "");
        }
        return respuesta;
    }

    public String addTag(String tag, String dato) {
        return "<" + tag + ">" + dato + "</" + tag + ">";
    }

}
