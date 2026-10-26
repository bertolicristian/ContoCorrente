/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author bertoli.cristian
 */
public class Main {

    public static void main(String[] args) {
        ContoCorrente c = new ContoCorrente("IT60X0542811101000000123456");

        c.versa(200);
        c.preleva(50);
        c.versa(100);

        System.out.println("IBAN: " + c.getIban());
        System.out.println("Movimenti:");
        c.stampaMovimenti();
        System.out.println("Saldo: " + c.getSaldo());

        System.out.println();
        System.out.println("Totale versamenti: " + c.totaleVersamenti());
        System.out.println("Totale prelievi: " + c.totalePrelievi());
        System.out.println("Versamento medio: " + c.versamentoMedio());
        System.out.println("Prelievo medio: " + c.prelievoMedio());
        System.out.println("N. versamenti: " + c.numeroVersamenti());
        System.out.println("N. prelievi: " + c.numeroPrelievi());
        System.out.println("Versamento massimo: " + c.versamentoMassimo());
        System.out.println("Prelievo massimo: " + c.prelievoMassimo());

        System.out.println();
        System.out.println("Prelievo di 1000: " + c.preleva(1000));
        System.out.println("Versamento di -5: " + c.versa(-5));
    }
}

