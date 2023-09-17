package no.itfakultetet.maskiner;

public class RapportImpl implements Rapport {

    public void printRapportHeader() {
        int maskiner = Datamaskin.antallDatamaskiner;
        System.out.println(maskiner + (maskiner == 1 ? " maskin" : " maskiner") + " i parken:");
    }

    @Override
    public void visRapport(String maskinType) {
        int sum = 0;
        if (maskinType.equals("Desktop")) {
            int antallMaskiner = Desktop.antallDesktopper;
            sum = Desktop.desktopper.stream().mapToInt(Datamaskin::getPris).sum();
            System.out.println(antallMaskiner + (antallMaskiner > 1 ? " Desktopper: " : " Desktop"));
            printTabellHeader();
            Desktop.desktopper.forEach(a -> System.out.printf("%-15s %-6d %-6d\n", a.getMerke(), a.getÅrsmodell(), a.getPris()));
        } else if (maskinType.equals("Laptop")) {
            int antallMaskiner = Laptop.antallLaptoper;
            System.out.println(antallMaskiner + (antallMaskiner > 1 ? " Laptopper: " : " Laptop"));
            sum = Laptop.laptopper.stream().mapToInt(Datamaskin::getPris).sum();
            printTabellHeader();
            Laptop.laptopper.forEach(a -> System.out.printf("%-15s %-6d %-6d\n", a.getMerke(), a.getÅrsmodell(), a.getPris()));
        }

        System.out.println("-".repeat(30));
        System.out.printf("%-22s %-6d\n", "SUM", sum);
        System.out.println("-".repeat(30));

    }

    private void printTabellHeader() {
        System.out.println("-".repeat(30));
        System.out.printf("%-15s %-6s %-6s\n", "Merke", "Modell", "Pris");
    }

    public void printRapportFooter() {

        System.out.println("-".repeat(30));
        System.out.printf("%-22s %-6d\n", "TOTALT", Desktop.sumPrisDatamaskiner);
        System.out.println("-".repeat(30));
        System.out.println();
    }


    @Override
    public void lagreRapportTilFil() {
        // TODO
        // Lag metoder som skriver til file i ulike formater: csv, Json, XML, Excel
    }

    @Override
    public void lagreRapportIDB() {
        // TODO
        // Lag metode for å lagre maskinparken i en database - f.eks. PostgreSQL eller MongoDB
    }


}
