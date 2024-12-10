package DesignPatterns.Structural.Adapter;

import DesignPatterns.Structural.Adapter.ThirdParty.JustPayPG;

public class JustPayPGAdapter implements PaymentGatewayInterface {

    private final JustPayPG justPayPG;

    public JustPayPGAdapter(JustPayPG justPayPG) {
        this.justPayPG = justPayPG;
    }

    @Override
    public void doPayment(String paymentType, double amount) {
        justPayPG.doPayment(paymentType, amount);
    }

    @Override
    public boolean checkPaymentStatus(String paymentType, double amount) {
        return true;
    }
}
