package co.poli.edu.actividad.servicios;

import java.util.HashMap;
import java.util.Map;

public class FactoriaFlyWeight {

    private static final Map<String, PasaporteTipo> flyweights = new HashMap<>();

    public static PasaporteTipo getPasaporteTipo(String tipo, String colorCubierta, String idioma, String emisor) {
        String key = tipo + "-" + colorCubierta + "-" + idioma + "-" + emisor;
        return flyweights.computeIfAbsent(key, k -> new PasaporteTipo(tipo, colorCubierta, idioma, emisor));
    }

    public static int getTotalFlyweights() {
        return flyweights.size();
    }
}
