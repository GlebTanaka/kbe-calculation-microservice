package de.htwberlin.f4.calculationmicroservice.services;

import org.springframework.stereotype.Service;

/**
 * Service für das berrechnen der Mehrwertsteuer
 */
@Service
public class CalculateMehrwertsteuerService {
    /**
     * Berrechnet die die Mehrwertsteuer die noch auf den Preis gerrechnet werden muss
     * @param preis vor Steuern
     * @return Mehrwertsteuer als double
     */
    public double calculateMehrwertSteuer(double preis){
        return preis * 0.19;
    }
}
