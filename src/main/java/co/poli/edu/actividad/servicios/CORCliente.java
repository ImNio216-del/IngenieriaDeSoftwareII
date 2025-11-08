package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;

public class CORCliente {

    private CORHandler cadena;

    public CORCliente() {

        this.cadena = construirCadena();
    }

    private CORHandler construirCadena() {

        CORHandler validadorFormato = new CORFormatoID();
        CORHandler validadorDatos = new CORDatosRequeridos();
        CORHandler validadorTipo = new CORTipoPasaporte();


        validadorFormato.setSiguiente(validadorDatos);
        validadorDatos.setSiguiente(validadorTipo);


        return validadorFormato;
    }

    public String ejecutarValidacion(Pasaporte pasaporte) {
        return cadena.validar(pasaporte);
    }
}