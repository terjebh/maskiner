package no.itfakultetet.maskiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Laptop extends Datamaskin {

    public static int antallLaptoper;

    private int skjermstørrelse;
    private String batteriType;
    static List<Laptop> laptopper = new ArrayList<>();

    public Laptop() {
        super();
        antallLaptoper++;

    }

    static void lagNyLaptop() {
        System.out.println("Ny Laptop");
        Laptop l = new Laptop();
        Scanner leggInn = new Scanner(System.in);
        System.out.print("Tast inn merke: ");
        String merke = leggInn.nextLine();
        l.setMerke(merke);
        System.out.print("Tast inn årsmodell: ");
        Integer modell = leggInn.nextInt();
        l.setÅrsmodell(modell);
        System.out.print("Tast inn pris: ");
        Integer pris = leggInn.nextInt();
        l.setPris(pris);
        laptopper.add(l);
    }

    public int getSkjermstørrelse() {
        return skjermstørrelse;
    }

    public void setSkjermstørrelse(int skjermstørrelse) {
        this.skjermstørrelse = skjermstørrelse;
    }

    public String getBatteriType() {
        return batteriType;
    }

    public void setBatteriType(String batteriType) {
        this.batteriType = batteriType;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "skjermstørrelse=" + skjermstørrelse +
                ", batteriType='" + batteriType + '\'' +
                '}';
    }
}


