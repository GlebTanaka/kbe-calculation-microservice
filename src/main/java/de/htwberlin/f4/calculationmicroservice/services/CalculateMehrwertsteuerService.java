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
     * @return Mehrwertsteuer als double wenn der Preis größer als 0 ist
     * @throws IllegalArgumentException wenn der preis negativ oder 0 ist
     */
    public double calculateMehrwertSteuer(double preis) throws IllegalArgumentException{
        if(preis<=0){
            throw new IllegalArgumentException("Preis muss größer als 0 sein");
        }
        return preis * 0.19;
    }
}
