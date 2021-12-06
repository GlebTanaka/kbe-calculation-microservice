package de.htwberlin.f4.calculationmicroservice.services;

/**
 * Service für das berrechnen der Mehrwertsteuer
 */
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
