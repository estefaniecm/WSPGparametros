package com.guatex.parametros.services;

import com.guatex.parametros.datos.D_Consultas;
import com.guatex.parametros.entidades.E_RespuestaParametros;
import com.guatex.parametros.utils.ConvertidorXML;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ESTEFANIECM
 */
@WebService(serviceName = "WSPGparametros")
public class WSPGparametros {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "buscarParametros")
    public String buscarParametros(@WebParam(name = "datos") String datos) {
        System.out.println("datos: "+datos);
        E_RespuestaParametros respuesta = new D_Consultas().obtenerParametros(datos);
        return new ConvertidorXML().respuestaXML(respuesta);
    }
    
}
