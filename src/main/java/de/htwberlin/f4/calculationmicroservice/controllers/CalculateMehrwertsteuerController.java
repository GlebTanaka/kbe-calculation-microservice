package de.htwberlin.f4.calculationmicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.f4.calculationmicroservice.services.CalculateMehrwertsteuerService;
/**
 * Rest Controller Mehrwertsteuer
 */
@RestController
public class CalculateMehrwertsteuerController {

    @Autowired
    private CalculateMehrwertsteuerService calculator;

    /**
     * liefert die Mehrwertsteuer vom Produkt
     * @param preis vom Produkt
     * @return ResponseEntity<Double> enthält die errechnete Mehrwertsteuer
     */
    @GetMapping("/calculatemehrwertsteuer")
    public ResponseEntity<Double> calculateMehrwertSteuer(@RequestParam double preis){
        return ResponseEntity.ok(calculator.calculateMehrwertSteuer(preis));
    }
    
}
