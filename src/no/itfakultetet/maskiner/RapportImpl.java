package no.itfakultetet.maskiner;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class RapportImpl implements Rapport {
    public long antallDatamaskiner;
    public int sumPrisDatamaskiner;
    private StringBuilder rapportText = new StringBuilder();
    private Formatter fm = new Formatter(rapportText);

    public void lagRapport() throws SQLException {
        printRapportHeader();
        visRapport("Laptop");
        visRapport("Desktop");
        // TODO
        // visRapport("Server");
        printRapportFooter();
        System.out.println(rapportText.toString());
        Scanner lagreSc = new Scanner(System.in);
        System.out.print("Lagre som tekstfil? (J/N): ");
        if (lagreSc.next().equalsIgnoreCase("J")) {
            lagreRapportTilFil(rapportText);
        } else {
            return;
        }

    }

    @Override
    public void visRapport(String maskinType) throws SQLException {
        int sum = 0;
        List<Datamaskin> maskinListe = Postgres.hentMaskiner(maskinType);
        long antallMaskiner = maskinListe.size();
        antallDatamaskiner += antallMaskiner;
        sum = maskinListe.stream().mapToInt(Datamaskin::getPris).sum();
        sumPrisDatamaskiner += sum;
        rapportText.append(antallMaskiner).append(antallMaskiner > 1 ? " " + maskinType + "er: \n" : " " + maskinType + "\n");
        printTabellHeader();
        maskinListe.forEach(a -> fm.format("%-25s %-6d %6d\n", a.getMerke(), a.getÅrsmodell(), a.getPris()));
        rapportText.append("-".repeat(40) + "\n");
        fm.format("%-32s %6d\n", "SUM " + maskinType, sum);
        rapportText.append("-".repeat(40) + "\n");
    }


    public void printRapportHeader() {
        rapportText.append("Inventarliste\n");
        rapportText.append("-".repeat(40) + "\n");
    }

    private void printTabellHeader() {
        rapportText.append("-".repeat(40) + "\n");
        fm.format("%-25s %-6s %6s\n", "Merke", "Modell", "Pris");
    }

    public void printRapportFooter() {

        rapportText.append("-".repeat(40) + "\n");
        fm.format("%-32s %6d\n", "SUM TOTALT", sumPrisDatamaskiner);
        long maskiner = antallDatamaskiner;
        fm.format("%-32s %6d\n", "MASKINER TOTALT", maskiner);
        fm.format("-".repeat(40) + "\n");

    }

    @Override
    public void lagreRapportTilFil(StringBuilder rapportText) {
        String filnavn = "Maskinpark_Rapport_" + LocalDate.now() + ".txt";
        try {
            Files.write(Paths.get(filnavn), Collections.singleton(rapportText));
            System.out.println("Rapporten er lagret som: " + filnavn);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void lagreRapportIDB() {
        // TODO
        // Lag metode for å lagre maskinparken i en database - f.eks. PostgreSQL eller MongoDB
    }


}
