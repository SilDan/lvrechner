package com.silvandaniel.lvrechner.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BerechnungsAnfrage {

    private int alter;
    private double versicherungssumme;
    private int laufzeit;

    // Eigener Konstruktor
    public BerechnungsAnfrage(int alter, double versicherungssumme, int laufzeit) {
        this.alter = alter;
        this.versicherungssumme = versicherungssumme;
        this.laufzeit = laufzeit;
    }

    // Eigene Methoden
    public boolean istLaufzeitGueltig() {
        return laufzeit > 0 && laufzeit <= 40;
    }
}