package no.itfakultetet.maskiner;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1 = legg til en ny Laptop");
            System.out.println("2 = legg til en ny Desktop");
            System.out.println("3 = legg til en ny Server");
            System.out.println("4 = vis alle maskiner");
            System.out.println("q = Avslutt");
            System.out.println("-".repeat(40));
            String menyvalg = in.next();
            if (menyvalg.equals("q")) {
                System.out.println("Farvel...");
                System.exit(0);
            } else if (menyvalg.equals("1")) {
                Laptop.lagNyLaptop();
            } else if (menyvalg.equals("2")) {
                Desktop.lagNyDesktop();
            } else if (menyvalg.equals("3")) {
                Server s = new Server();
            } else if (menyvalg.equals("4")) {
                System.out.println(Datamaskin.antallDatamaskiner + " maskiner i parken:");
                RapportImpl rapport = new RapportImpl();
                if (Laptop.antallLaptoper > 0) rapport.visRapport("Laptop");
                if (Desktop.antallDesktopper > 0) rapport.visRapport("Desktop");
                if(Datamaskin.antallDatamaskiner > 0) Datamaskin.printSum();
            } else {
                System.out.println("Ukjent menyvalg");
            }
        }

    }

}
