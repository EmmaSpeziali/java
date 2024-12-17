package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Traghetto {
    private boolean available = true;

    public synchronized void board(String groupName) {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;

        System.out.println("Il gruppo di " + groupName + " si sta imbarcando sul traghetto.");
        try {
            Thread.sleep(3000); // Simula il viaggio verso l'isola
            System.out.println("Il gruppo di " + groupName + " è arrivato all'isola.");
            logToFile(groupName); // Registra il viaggio nel file
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Il traghetto sta tornando al porto...");
        try {
            Thread.sleep(2000); // Simula il ritorno al porto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Il traghetto è tornato al porto.");
        available = true;
        notifyAll();
    }

    private void logToFile(String groupName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("viaggi_traghetto.txt", true))) {
            writer.write("Il gruppo di " + groupName + " ha completato il viaggio - " + java.time.LocalDate.now());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura nel file: " + e.getMessage());
        }
    }
}
