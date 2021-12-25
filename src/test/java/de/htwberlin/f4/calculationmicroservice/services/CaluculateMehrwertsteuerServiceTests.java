package de.htwberlin.f4.calculationmicroservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaluculateMehrwertsteuerServiceTests {
    @Autowired
    private CalculateMehrwertsteuerService service;

    @Test
    public void calculateMehrwertSteuerGutTest(){
        double price = 10.0;
        double s = service.calculateMehrwertSteuer(price);
        assertEquals(1.9, s);
    }

    @Test
    public void calculateMehrwertSteuerMaxTest(){
        double price = 1.7*Math.pow(10, 308);
        double s = service.calculateMehrwertSteuer(price);
        assertEquals(0.323*Math.pow(10, 308), s);
    }

    @Test
    public void calculateMehrwertSteuerNegativeTest(){
        double price = -10;
        assertThrows(IllegalArgumentException.class, () -> service.calculateMehrwertSteuer(price), "Preis muss größer als 0 sein");
    }

    @Test
    public void calculateMehrwertSteuerZeroTest(){
        double price = 0;
        assertThrows(IllegalArgumentException.class, () -> service.calculateMehrwertSteuer(price), "Preis muss größer als 0 sein");
    }

    @Test
    public void calculateMehrwertSteuerMinTest(){
        double price = Double.MIN_VALUE;
        double s = service.calculateMehrwertSteuer(price);
        assertEquals(0, s);
    }
}
