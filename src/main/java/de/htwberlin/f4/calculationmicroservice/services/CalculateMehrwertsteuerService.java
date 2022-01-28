package de.htwberlin.f4.calculationmicroservice.services;

import org.springframework.stereotype.Service;

@Service
public class CalculateMehrwertsteuerService {
    /**
     * @throws IllegalArgumentException if price is Negative or Zero
     */
    public double calculateMehrwertSteuer(double preis) throws IllegalArgumentException {
        if (preis <= 0) {
            throw new IllegalArgumentException("Preis muss größer als 0 sein");
        }
        return preis * 0.19;
    }
}
