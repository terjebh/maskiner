package no.itfakultetet.appxx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desktop extends Datamaskin {
    public static int antallDesktopper;
    static List<Desktop> desktopper = new ArrayList<>();

    public Desktop() {
        super();
        antallDesktopper++;
    }

    public static void lagNyDesktop() {
        System.out.println("Ny Desktop");
        Desktop d = new Desktop();
        Scanner leggInn = new Scanner(System.in);
        System.out.println("Tast inn merke: ");
        String merke = leggInn.nextLine();
        d.setMerke(merke);
        System.out.println("Tast inn årsmodell: ");
        Integer modell = leggInn.nextInt();
        d.setÅrsmodell(modell);
        System.out.print("Tast inn pris: ");
        Integer pris = leggInn.nextInt();
        d.setPris(pris);
        desktopper.add(d);
    }


}
