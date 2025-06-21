package com.silvandaniel.lvrechner.controller;

import com.silvandaniel.lvrechner.model.BerechnungsAnfrage;
import com.silvandaniel.lvrechner.service.LVRechnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Basis-URL
public class LVRechnerController {

    private final LVRechnerService service;

    @Autowired
    public LVRechnerController(LVRechnerService service) {
        this.service = service;
    }

    @PostMapping("/berechne")
    public ResponseEntity<Double> berechneBeitrag(@RequestBody BerechnungsAnfrage anfrage) {
        try {
            double beitrag = service.berechneBeitrag(
                    anfrage.getAlter(),
                    anfrage.getVersicherungssumme(),
                    anfrage.getLaufzeit()
            );
            return ResponseEntity.ok(beitrag);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/berechne")
    public ResponseEntity<Double> berechneBeitragMitParametern(
            @RequestParam int alter,
            @RequestParam double versicherungssumme,
            @RequestParam int laufzeit) {
        try {
            double beitrag = service.berechneBeitrag(alter, versicherungssumme, laufzeit);
            return ResponseEntity.ok(beitrag);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
