
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

class FahrkartenautomatUebungMethoden {
	public static void main(String[] args) {
		double zuZahlenderBetrag = 0;
		double eingezahlterGesamtbetrag;
		
		Scanner tastatur = new Scanner(System.in);
		//Aufgabe 5.2.1
		String willkommenstext = begruessung();
		System.out.println(willkommenstext);
		
		//Aufgabe 5.2.2
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		//Aufgabe 5.2.3
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		//Aufgabe 5.2.4
		fahrkartenAusgeben ();
		//Aufgabe 5.2.5
		rueckgeldAusgeben (zuZahlenderBetrag, eingezahlterGesamtbetrag);

	}
	
	public static String begruessung() {
		String text = "Herzlich Willkommen! ";
		
		return text;
	}
	
	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		int artDesTickets;
		double anzahlTickets;
		double zuZahlenderBetrag;
		double ticketPreis = 0;
		double preisKurzstrecke = 2;
		double preisEinzelfahrschein = 3;
		double preisTageskarte = 8.8;
		double preisVierFahrtenKarte = 9.4;
		System.out.print("Anzahl der Tickets (Stück): ");
		anzahlTickets = tastatur.nextDouble();
		while (anzahlTickets < 1 || anzahlTickets > 10) {
			System.out.print("Anzahl der Tickets (Stück): ");
			anzahlTickets = tastatur.nextDouble();
		}
		
		System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
		System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
		System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
		System.out.println("Tageskarte AB [8,80 EUR] (3)");
		System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
		artDesTickets = tastatur.nextInt();
		if(artDesTickets == 1) {
			ticketPreis = preisKurzstrecke;
		}
		if(artDesTickets == 2) {
			ticketPreis = preisEinzelfahrschein;
		}
		if (artDesTickets == 3) {
			ticketPreis = preisTageskarte;
		}
		if (artDesTickets == 4) {
			ticketPreis = preisVierFahrtenKarte;
		}
		
		zuZahlenderBetrag = anzahlTickets * ticketPreis;
		return zuZahlenderBetrag;
	}
	
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;
	
		
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: " +  "%.2f \n" , nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			double eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}
	
	public static void fahrkartenAusgeben () {
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
	}
	
	public static void rueckgeldAusgeben (double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
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
	}
}