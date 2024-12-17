package com.example;

public class Bus extends Thread {
    private GruppoTuristi group;
    private Traghetto traghetto;

    public Bus(GruppoTuristi group, Traghetto traghetto) {
        this.group = group;
        this.traghetto = traghetto;
    }

    @Override
    public void run() {
        try {
            System.out.println("Il gruppo di " + group.getNationality() + " è partito dagli alloggi verso il porto.");
            Thread.sleep(2000); // Simula il tempo di arrivo al porto
            System.out.println("Il gruppo di " + group.getNationality() + " è arrivato al porto.");
            System.out.println("Il gruppo di " + group.getNationality() + " sta pagando i biglietti.");
            Thread.sleep(1000); // Simula il pagamento dei biglietti

            traghetto.board(group.getNationality());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
