package no.itfakultetet.maskiner;

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
