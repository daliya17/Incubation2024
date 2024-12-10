package DesignPatterns.Structural.Adapter;

import DesignPatterns.Structural.Adapter.ThirdParty.CCAvenuePG;

public class CCAvenuePGAdapter implements PaymentGatewayInterface {

    private final CCAvenuePG ccAvenuePG;

    public CCAvenuePGAdapter(CCAvenuePG ccAvenuePG) {
        this.ccAvenuePG = ccAvenuePG;
    }

    @Override
    public void doPayment(String paymentType, double amount) {
        ccAvenuePG.doPayment(paymentType, amount);
    }

    @Override
    public boolean checkPaymentStatus(String paymentType, double amount) {
        return false;
    }
}
