package com.example;

public class Main {
    public static void main(String[] args) {
        Traghetto traghetto = new Traghetto();

        // Creazione dei gruppi
        GruppoTuristi francesi = new GruppoTuristi("Francesi", 25);
        GruppoTuristi tedeschi = new GruppoTuristi("Tedeschi", 25);
        GruppoTuristi spagnoli = new GruppoTuristi("Spagnoli", 25);

        // Creazione degli autobus
        Bus busFrancesi = new Bus(francesi, traghetto);
        Bus busTedeschi = new Bus(tedeschi, traghetto);
        Bus busSpagnoli = new Bus(spagnoli, traghetto);

        // Avvio dei thread
        Thread t1 = new Thread(busFrancesi);
        Thread t2 = new Thread(busTedeschi);
        Thread t3 = new Thread(busSpagnoli);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tutti i turisti hanno completato i viaggi. Programma terminato.");
    }
}
