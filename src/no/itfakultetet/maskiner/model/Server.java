package no.itfakultetet.maskiner.model;

import no.itfakultetet.maskiner.model.Datamaskin;

public class Server extends Datamaskin {
    public static int antallServere;

    public Server() {
    }

    public Server(String merke, int modell, int pris) {
        setMerke(merke);
        setÅrsmodell(modell);
        setPris(pris);
    }

}
