/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author bertoli.cristian
 */
public class ContoCorrente {

    private String iban;
    private double saldo;
    private double[] movimenti;
    private int numMovimenti;

    public ContoCorrente(String iban) {
        this.iban = iban;
        this.saldo = 0;
        this.movimenti = new double[100];
        this.numMovimenti = 0;
    }

    // ---------- Operazioni ----------

    public boolean versa(double importo) {
        if (importo > 0 && numMovimenti < movimenti.length) {
            saldo = saldo + importo;
            movimenti[numMovimenti] = importo;
            numMovimenti++;
            return true;
        }
        return false;
    }

    public boolean preleva(double importo) {
        if (importo > 0 && importo <= saldo && numMovimenti < movimenti.length) {
            saldo = saldo - importo;
            movimenti[numMovimenti] = -importo;
            numMovimenti++;
            return true;
        }
        return false;
    }

    // ---------- Consultazione ----------

    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    public void stampaMovimenti() {
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] > 0) {
                System.out.println("+" + movimenti[i]);
            } else {
                System.out.println(movimenti[i]);
            }
        }
    }

    // ---------- Statistiche sui versamenti ----------

    public double totaleVersamenti() {
        double totale = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] > 0) {
                totale = totale + movimenti[i];
            }
        }
        return totale;
    }

    public int numeroVersamenti() {
        int n = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] > 0) {
                n++;
            }
        }
        return n;
    }

    public double versamentoMedio() {
        int n = numeroVersamenti();
        if (n == 0) {
            return 0;
        }
        return totaleVersamenti() / n;
    }

    public double versamentoMassimo() {
        double max = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] > max) {
                max = movimenti[i];
            }
        }
        return max;
    }

    // ---------- Statistiche sui prelievi ----------

    public double totalePrelievi() {
        double totale = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] < 0) {
                totale = totale - movimenti[i];   // meno per meno = più
            }
        }
        return totale;
    }

    public int numeroPrelievi() {
        int n = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (movimenti[i] < 0) {
                n++;
            }
        }
        return n;
    }

    public double prelievoMedio() {
        int n = numeroPrelievi();
        if (n == 0) {
            return 0;
        }
        return totalePrelievi() / n;
    }

    public double prelievoMassimo() {
        double max = 0;
        for (int i = 0; i < numMovimenti; i++) {
            if (-movimenti[i] > max) {
                max = -movimenti[i];
            }
        }
        return max;
    }
}
