package no.itfakultetet.maskiner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desktop extends Datamaskin {

    public Desktop() {

    }

    public Desktop(String merke, int modell, int pris) {
        setMerke(merke);
        setÅrsmodell(modell);
        setPris(pris);
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
        System.out.print("Lagre i Database? (J/N): ");
        String lagreValg = leggInn.next();
        if (lagreValg.equalsIgnoreCase("J")) {
            Postgres.insertMaskin(d);
        };
    }


}
