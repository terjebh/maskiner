package no.itfakultetet.appxx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static no.itfakultetet.appxx.Desktop.antallDesktopper;

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
        System.out.println("Tast inn merke: ");
        String merke = leggInn.nextLine();
        l.setMerke(merke);
        System.out.println("Tast inn årsmodell: ");
        Integer modell = leggInn.nextInt();
        l.setÅrsmodell(modell);
        System.out.print("Tast inn pris: ");
        Integer pris = leggInn.nextInt();
        l.setPris(pris);
        laptopper.add(l);
    }

    public static void visLaptopper() {
        System.out.println(antallLaptoper + (antallLaptoper > 1? " Laptopper: " : " Laptop"));
        System.out.println("-".repeat(30));
        System.out.printf("%-15s %-6s %-6s\n", "Merke", "Modell", "Pris");
        laptopper.forEach(a -> {
            System.out.printf("%-15s %-6d %-6d\n", a.getMerke(), a.getÅrsmodell(), a.getPris());
        });
        System.out.println("-".repeat(30));
        int sum = laptopper.stream().mapToInt(Datamaskin::getPris).sum();
        Datamaskin.sumPrisDatamaskiner+=sum;
        System.out.printf("%-22s %-6d\n","SUM",sum);
        System.out.println("-".repeat(30));
        System.out.println();
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


