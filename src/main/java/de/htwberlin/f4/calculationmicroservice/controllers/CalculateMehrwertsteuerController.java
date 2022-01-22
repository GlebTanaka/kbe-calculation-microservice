package de.htwberlin.f4.calculationmicroservice.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.f4.calculationmicroservice.services.CalculateMehrwertsteuerService;

/**
 * Rest Controller Mehrwertsteuer
 */
@Validated
@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculateMehrwertsteuerController {

    @Autowired
    private CalculateMehrwertsteuerService calculator;

    @GetMapping("/calculatemehrwertsteuer")
    @ApiOperation(value = "Calculate Mehrwersteuer",
            notes = "Provide a price greater than zero to calculate the Mehrwertstuer of this price",
            response = Double.class)
    public ResponseEntity<Double> calculateMehrwertSteuer(
            @ApiParam(value = "price value needs to be greater than 0", required = true, example = "100")
            @Positive
            @NotNull
            @RequestParam double preis) {
        return ResponseEntity.ok(calculator.calculateMehrwertSteuer(preis));
    }
}
