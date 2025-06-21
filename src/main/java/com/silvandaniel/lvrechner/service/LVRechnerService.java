package com.silvandaniel.lvrechner.service;

import org.springframework.stereotype.Service;

@Service
public class LVRechnerService {
    /**
     * Berechnet den monatlichen Beitrag für eine Lebensversicherung.
     *
     * @param alter              Das Alter der versicherten Person
     * @param versicherungssumme Die Versicherungssumme in Euro
     * @param laufzeit           Die Laufzeit der Versicherung in Jahren
     * @return Der monatliche Beitrag in Euro
     */
    public double berechneBeitrag(int alter, double versicherungssumme, int laufzeit) {
        if (alter < 0 || versicherungssumme <= 0 || laufzeit <= 0) {
            throw new IllegalArgumentException("Ungültige Eingabewerte: Alter, Versicherungssumme und Laufzeit müssen positiv sein.");
        }

        double grundBeitrag = versicherungssumme / (laufzeit * 12); // Monatsbeitrag
        double risikozuschlag = (alter > 50) ? 1.3 : 1.0; // Zuschlag bei Alter über 50

        return grundBeitrag * risikozuschlag;
    }

}
