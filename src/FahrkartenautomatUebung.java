
//1. Test
//Fahrpreis: 2,5
//
//Erste Münze: 2
//
//Zweite Münze: 2

//2. Test
//Fahrpreis: 2,1
//
//Erste Münze: 2
//
//Zweite Münze: 2

import java.util.Scanner;

class FahrkartenautomatUebung {
	public static void main(String[] args) {
		
		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag = 0;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		double anzahlTickets;
		int artDesTickets;
		//Aufgabe 4.3
		double preisKurzstrecke = 2;
		double preisEinzelfahrschein = 3;
		double preisTageskarte = 8.8;
		double preisVierFahrtenKarte = 9.4;

		// 1
		// Geldbetrag eingeben
//		System.out.print("Zu zahlender Betrag (Euro): ");
//		zuZahlenderBetrag = tastatur.nextDouble();
		
		System.out.print("Anzahl der Tickets (Stück): ");
		anzahlTickets = tastatur.nextDouble();
		// Aufgabe 4.2
		while (anzahlTickets < 1 || anzahlTickets > 10) {
			System.out.print("Anzahl der Tickets (Stück): ");
			anzahlTickets = tastatur.nextDouble();
		}
		
		//Aufgabe 4.3
		System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
		System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
		System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
		System.out.println("Tageskarte AB [8,80 EUR] (3)");
		System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
		artDesTickets = tastatur.nextInt();
		if(artDesTickets == 1) {
			zuZahlenderBetrag = preisKurzstrecke;
		}
		if(artDesTickets == 2) {
			zuZahlenderBetrag = preisEinzelfahrschein;
		}
		if (artDesTickets == 3) {
			zuZahlenderBetrag = preisTageskarte;
		}
		if (artDesTickets == 4) {
			zuZahlenderBetrag = preisVierFahrtenKarte;
		}
		
		
		// 2
		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		
//		if (zuZahlenderBetrag < 0) {
//			System.out.println("Der Ticketpreis ist unzulässig und wird auf 1 gesetzt.");
//			zuZahlenderBetrag = 1;
//		}
		

		
		
		
		while (eingezahlterGesamtbetrag < anzahlTickets * zuZahlenderBetrag) {
			nochZuZahlen = anzahlTickets * zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: " +  "%.2f \n" , nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
	
		
		// 3
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
		// 4
		// Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag * anzahlTickets;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		} 
		
		
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}