package de.htwberlin.f4.calculationmicroservice.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.f4.calculationmicroservice.services.CalculateMehrwertsteuerService;

/**
 * Rest Controller Mehrwertsteuer
 */
@Validated
@RestController
public class CalculateMehrwertsteuerController {

    @Autowired
    private CalculateMehrwertsteuerService calculator;

    /**
     * liefert die Mehrwertsteuer vom Produkt
     * 
     * @param preis vom Produkt
     * @return ResponseEntity<Double> enthält die errechnete Mehrwertsteuer
     */
    @GetMapping("/calculatemehrwertsteuer")
    public ResponseEntity<Double> calculateMehrwertSteuer(@Min(0) @NotNull @RequestParam double preis) {
        return ResponseEntity.ok(calculator.calculateMehrwertSteuer(preis));
    }

    /**
     * händelt ConstraintViolationException
     * @param e ConstraintViolationException
     * @return ResponseEntity mit Validierungsfehlermeldung
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Validation Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * händelt NumberFormatException
     * @param e NumberFormatException
     * @return ResponseEntity mit fehlermeldung
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleNumberFormatException(NumberFormatException e) {
        return new ResponseEntity<>("NumberFormatException: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
