package no.itfakultetet.maskiner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desktop extends Datamaskin {
    public static int antallDesktopper;
    static List<Datamaskin> desktopper = new ArrayList<>();

    public Desktop() {
        super();
        antallDesktopper++;
    }

    public static void lagNyDesktop() throws SQLException {
        System.out.println("Ny Desktop");
        Desktop d = new Desktop();
        Scanner leggInn = new Scanner(System.in);
        System.out.print("Tast inn merke: ");
        String merke = leggInn.nextLine();
        d.setMerke(merke);
        System.out.print("Tast inn årsmodell: ");
        Integer modell = leggInn.nextInt();
        d.setÅrsmodell(modell);
        System.out.print("Tast inn pris: ");
        Integer pris = leggInn.nextInt();
        d.setPris(pris);
        desktopper.add(d);
        System.out.print("Lagre i Database? (J/N): ");
        String lagreValg = leggInn.next();
        if (lagreValg.toUpperCase().equals("J")) {
            Postgres.insertMaskin(d);
        };
    }


}
